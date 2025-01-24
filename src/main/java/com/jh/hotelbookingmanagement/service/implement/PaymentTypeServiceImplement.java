package com.jh.hotelbookingmanagement.service.implement;

import com.jh.hotelbookingmanagement.dto.request.PaymentTypeRequest;

import com.jh.hotelbookingmanagement.dto.response.PaymentTypeResponse;
import com.jh.hotelbookingmanagement.entity.PaymentType;

import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import com.jh.hotelbookingmanagement.mapper.PaymentTypeMapper;


import com.jh.hotelbookingmanagement.repository.PaymentTypeRepository;

import com.jh.hotelbookingmanagement.service.PaymentTypeService;
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
public class PaymentTypeServiceImplement implements PaymentTypeService {
    PaymentTypeRepository paymentTypeRepository;
    PaymentTypeMapper paymentTypeMapper;

    @Override
    public PaymentTypeResponse createPaymentType(PaymentTypeRequest request) {
        PaymentType paymentType = paymentTypeMapper.toPaymentType(request);

        paymentType = paymentTypeRepository.save(paymentType);
        return paymentTypeMapper.toPaymentTypeResponse(paymentType);
    }

    @Override
    public List<PaymentTypeResponse> getAllPaymentType() {
        return paymentTypeRepository.findAll().stream()
                .map(paymentTypeMapper::toPaymentTypeResponse).toList();
    }

    @Override
    public PaymentTypeResponse updatePaymentType(Long paymentTypeId, PaymentTypeRequest request) {
        PaymentType paymentType = paymentTypeRepository.findById(paymentTypeId)
                .orElseThrow(()->new AppException(ErrorCode.BOOKING_METHOD_NOT_FOUND));
        paymentTypeMapper.updatePaymentType(paymentType, request);
        return paymentTypeMapper.toPaymentTypeResponse(paymentTypeRepository.save(paymentType));
    }

    @Override
    public void deletePaymentType(Long paymentTypeId) {
        paymentTypeRepository.deleteById(paymentTypeId);
    }
}
