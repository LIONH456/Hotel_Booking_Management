package com.jh.hotelbookingmanagement.service;

import com.jh.hotelbookingmanagement.dto.request.PaymentStatusRequest;
import com.jh.hotelbookingmanagement.dto.response.PaymentStatusResponse;
import java.util.List;

public interface PaymentStatusService {
    PaymentStatusResponse createPaymentStatus(PaymentStatusRequest request);
    PaymentStatusResponse getPaymentStatusById(Long id);
    List<PaymentStatusResponse> getAllPaymentStatus();
    PaymentStatusResponse updatePaymentStatus(Long id, PaymentStatusRequest request);
    void deletePaymentStatus(Long id);
} 