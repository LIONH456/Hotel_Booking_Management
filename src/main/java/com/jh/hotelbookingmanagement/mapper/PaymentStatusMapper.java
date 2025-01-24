package com.jh.hotelbookingmanagement.mapper;

import com.jh.hotelbookingmanagement.dto.request.PaymentStatusRequest;
import com.jh.hotelbookingmanagement.dto.response.PaymentStatusResponse;
import com.jh.hotelbookingmanagement.entity.PaymentStatus;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PaymentStatusMapper {
    PaymentStatus toPaymentStatus(PaymentStatusRequest request);
    PaymentStatusResponse toPaymentStatusResponse(PaymentStatus paymentStatus);
    void updatePaymentStatus(@MappingTarget PaymentStatus paymentStatus, PaymentStatusRequest request);
} 