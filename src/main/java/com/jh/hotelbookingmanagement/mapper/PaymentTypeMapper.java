package com.jh.hotelbookingmanagement.mapper;

import com.jh.hotelbookingmanagement.dto.request.PaymentTypeRequest;
import com.jh.hotelbookingmanagement.dto.response.PaymentTypeResponse;
import com.jh.hotelbookingmanagement.entity.PaymentType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PaymentTypeMapper {
    PaymentType toPaymentType(PaymentTypeRequest request);
    PaymentTypeResponse toPaymentTypeResponse(PaymentType paymentType);
    void updatePaymentType(@MappingTarget PaymentType paymentType, PaymentTypeRequest request);
}
