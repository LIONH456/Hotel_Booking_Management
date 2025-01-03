package com.jh.hotelbookingmanagement.service.Implement;

import com.jh.hotelbookingmanagement.dto.request.ServiceUsageRequest;
import com.jh.hotelbookingmanagement.dto.response.ServiceUsageResponse;
import com.jh.hotelbookingmanagement.entity.BookingDetail;
import com.jh.hotelbookingmanagement.entity.ServiceUsage;
import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import com.jh.hotelbookingmanagement.mapper.ServiceUsageMapper;
import com.jh.hotelbookingmanagement.repository.BookingDetailRepository;
import com.jh.hotelbookingmanagement.repository.ProvidedServicesRepository;
import com.jh.hotelbookingmanagement.repository.ServiceUsageRepository;
import com.jh.hotelbookingmanagement.service.ServiceUsageService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Transactional
public class ServiceUsageServiceImplement implements ServiceUsageService {
    private final ProvidedServicesRepository providedServicesRepository;
    BookingDetailRepository bookingDetailRepository;
    ServiceUsageRepository serviceUsageRepository;
    ServiceUsageMapper serviceUsageMapper;

    @Override
    public ServiceUsageResponse createServiceUsage(ServiceUsageRequest request) {
        ServiceUsage serviceUsage = serviceUsageMapper.toServiceUsage(request);
        BookingDetail bookingDetail = bookingDetailRepository.findById(request.getBookingDetailId()).orElseThrow(()->new AppException(ErrorCode.BOOKING_NOT_FOUND));
        serviceUsage.setBookingDetail(bookingDetail);
        serviceUsage.setServiceCharge(request.getQuantity() * serviceUsageRepository.getUnitPriceByServiceId(request.getServiceId()));
        serviceUsage.setService(providedServicesRepository.findById(request.getServiceId()).orElseThrow(()->new AppException(ErrorCode.SERVICE_NOT_FOUND)));

        serviceUsage = serviceUsageRepository.save(serviceUsage);

        serviceUsageRepository.updateServiceCharge(request.getBookingDetailId());
        bookingDetail.setTotalAmount(bookingDetail.getRoomCharge()+bookingDetail.getItemCharge()+bookingDetail.getServiceCharge());
        bookingDetailRepository.save(bookingDetail);
        return serviceUsageMapper.toServiceUsageResponse(serviceUsage);
    }

    @Override
    public List<ServiceUsageResponse> getAllServiceUsage() {
        return serviceUsageRepository.findAll().stream()
                .map(serviceUsageMapper::toServiceUsageResponse).toList();
    }

    @Override
    public ServiceUsageResponse updateServiceUsage(String serviceUsageId, ServiceUsageRequest request) {
        ServiceUsage serviceUsage = serviceUsageRepository.findById(serviceUsageId)
                .orElseThrow(()->new AppException(ErrorCode.BOOKING_METHOD_NOT_FOUND));
        serviceUsageMapper.updateServiceUsage(serviceUsage, request);
        return serviceUsageMapper.toServiceUsageResponse(serviceUsageRepository.save(serviceUsage));
    }

    @Override
    public void deleteServiceUsage(String serviceUsageId) {
        serviceUsageRepository.deleteById(serviceUsageId);
    }
}
