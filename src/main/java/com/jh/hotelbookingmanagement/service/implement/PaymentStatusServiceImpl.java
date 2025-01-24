package com.jh.hotelbookingmanagement.service.implement;

import com.jh.hotelbookingmanagement.dto.request.PaymentStatusRequest;
import com.jh.hotelbookingmanagement.dto.response.PaymentStatusResponse;
import com.jh.hotelbookingmanagement.entity.PaymentStatus;
import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import com.jh.hotelbookingmanagement.mapper.PaymentStatusMapper;
import com.jh.hotelbookingmanagement.repository.PaymentStatusRepository;
import com.jh.hotelbookingmanagement.service.PaymentStatusService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.AccessLevel;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PaymentStatusServiceImpl implements PaymentStatusService {
    PaymentStatusRepository paymentStatusRepository;
    PaymentStatusMapper paymentStatusMapper;

    @Override
    @Transactional
    public PaymentStatusResponse createPaymentStatus(PaymentStatusRequest request) {
        PaymentStatus paymentStatus = paymentStatusMapper.toPaymentStatus(request);
        paymentStatus = paymentStatusRepository.save(paymentStatus);
        return paymentStatusMapper.toPaymentStatusResponse(paymentStatus);
    }

    @Override
    public PaymentStatusResponse getPaymentStatusById(Long id) {
        PaymentStatus paymentStatus = paymentStatusRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PAYMENT_STATUS_NOT_FOUND));
        return paymentStatusMapper.toPaymentStatusResponse(paymentStatus);
    }

    @Override
    public List<PaymentStatusResponse> getAllPaymentStatus() {
        return paymentStatusRepository.findAll().stream()
                .map(paymentStatusMapper::toPaymentStatusResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PaymentStatusResponse updatePaymentStatus(Long id, PaymentStatusRequest request) {
        PaymentStatus paymentStatus = paymentStatusRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PAYMENT_STATUS_NOT_FOUND));
        paymentStatusMapper.updatePaymentStatus(paymentStatus, request);
        return paymentStatusMapper.toPaymentStatusResponse(paymentStatusRepository.save(paymentStatus));
    }

    @Override
    @Transactional
    public void deletePaymentStatus(Long id) {
        if (!paymentStatusRepository.existsById(id)) {
            throw new AppException(ErrorCode.PAYMENT_STATUS_NOT_FOUND);
        }
        paymentStatusRepository.deleteById(id);
    }
} 