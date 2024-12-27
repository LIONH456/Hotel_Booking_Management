package com.jh.hotelbookingmanagement.service.Implement;

import com.jh.hotelbookingmanagement.dto.request.ProvidedServicesRequest;
import com.jh.hotelbookingmanagement.dto.response.ProvidedServicesResponse;
import com.jh.hotelbookingmanagement.entity.ProvidedServices;
import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import com.jh.hotelbookingmanagement.mapper.ProvidedServicesMapper;
import com.jh.hotelbookingmanagement.repository.ProvidedServicesRepository;
import com.jh.hotelbookingmanagement.service.ProvidedServicesService;
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
public class ProvidedServicesServiceImplement implements ProvidedServicesService {
    ProvidedServicesRepository providedServicesRepository;
    ProvidedServicesMapper providedServicesMapper;

    @Override
    public ProvidedServicesResponse createProvidedServices(ProvidedServicesRequest request) {
        ProvidedServices providedServices = providedServicesMapper.toProvidedServices(request);

        providedServices = providedServicesRepository.save(providedServices);
        return providedServicesMapper.toProvidedServicesResponse(providedServices);
    }

    @Override
    public List<ProvidedServicesResponse> getAllProvidedServices() {
        return providedServicesRepository.findAll().stream()
                .map(providedServicesMapper::toProvidedServicesResponse).toList();
    }

    @Override
    public ProvidedServicesResponse updateProvidedServices(Long providedServicesId, ProvidedServicesRequest request) {
        ProvidedServices providedServices = providedServicesRepository.findById(providedServicesId)
                .orElseThrow(()->new AppException(ErrorCode.SERVICE_NOT_FOUND));
        providedServicesMapper.updateProvidedServices(providedServices, request);
        return providedServicesMapper.toProvidedServicesResponse(providedServicesRepository.save(providedServices));
    }

    @Override
    public void deleteProvidedServices(Long providedServicesId) {
        providedServicesRepository.deleteById(providedServicesId);
    }

    @Override
    public ProvidedServicesResponse getProvidedServices(Long providedServicesId) {
        return providedServicesMapper.toProvidedServicesResponse(providedServicesRepository.findById(providedServicesId).orElseThrow(()->new AppException(ErrorCode.SERVICE_NOT_FOUND)));
    }
}
