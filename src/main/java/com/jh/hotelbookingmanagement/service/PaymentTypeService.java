package com.jh.hotelbookingmanagement.service;


import com.jh.hotelbookingmanagement.dto.request.BookingMethodRequest;
import com.jh.hotelbookingmanagement.dto.request.PaymentTypeRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingMethodResponse;
import com.jh.hotelbookingmanagement.dto.response.PaymentTypeResponse;

import java.util.List;

public interface PaymentTypeService {
    PaymentTypeResponse createPaymentType(PaymentTypeRequest request);
    
    List<PaymentTypeResponse> getAllPaymentType();

    PaymentTypeResponse updatePaymentType(Long paymentTypeId, PaymentTypeRequest request);

    void deletePaymentType(Long PaymentTypeId);
    
}
