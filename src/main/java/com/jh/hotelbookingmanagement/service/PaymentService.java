package com.jh.hotelbookingmanagement.service;

import com.jh.hotelbookingmanagement.dto.request.PaymentRequest;
import com.jh.hotelbookingmanagement.dto.response.PaymentResponse;
import java.util.List;

public interface PaymentService {
    PaymentResponse createPayment(PaymentRequest request);
    PaymentResponse getPaymentById(String paymentId);
    List<PaymentResponse> getAllPayments();
    PaymentResponse updatePayment(String paymentId, PaymentRequest request);
    void deletePayment(String paymentId);
    List<PaymentResponse> getPaymentsByBookingId(String bookingId);
} 