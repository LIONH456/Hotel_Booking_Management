package com.jh.hotelbookingmanagement.service;

import com.jh.hotelbookingmanagement.dto.request.PaymentTypeRequest;
import com.jh.hotelbookingmanagement.dto.response.PaymentTypeResponse;
import java.util.List;

public interface PaymentTypeService {
    PaymentTypeResponse createPaymentType(PaymentTypeRequest request);
    PaymentTypeResponse getPaymentTypeById(Long id);
    List<PaymentTypeResponse> getAllPaymentTypes();
    PaymentTypeResponse updatePaymentType(Long id, PaymentTypeRequest request);
    void deletePaymentType(Long id);
}
