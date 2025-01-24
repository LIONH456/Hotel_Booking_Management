package com.jh.hotelbookingmanagement.mapper;

import com.jh.hotelbookingmanagement.dto.request.PaymentRequest;
import com.jh.hotelbookingmanagement.dto.response.PaymentResponse;
import com.jh.hotelbookingmanagement.entity.Booking;
import com.jh.hotelbookingmanagement.entity.Payment;
import com.jh.hotelbookingmanagement.entity.PaymentStatus;
import com.jh.hotelbookingmanagement.entity.PaymentType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class PaymentMapper {
    
    public Payment toEntity(PaymentRequest request, Booking booking, PaymentType paymentType, PaymentStatus paymentStatus) {
        return Payment.builder()
                .paymentId(UUID.randomUUID().toString())
                .booking(booking)
                .amount(request.getAmount())
                .discount(request.getDiscount())
                .itemCharges(request.getItemCharges())
                .serviceCharges(request.getServiceCharges())
                .total(calculateTotal(request))
                .totalPaid(request.getAmount())
                .paidDate(LocalDateTime.now())
                .paymentType(paymentType)
                .paymentStatus(paymentStatus)
                .build();
    }
    
    public PaymentResponse toResponse(Payment payment) {
        return PaymentResponse.builder()
                .paymentId(payment.getPaymentId())
                .amount(payment.getAmount())
                .discount(payment.getDiscount())
                .itemCharges(payment.getItemCharges())
                .serviceCharges(payment.getServiceCharges())
                .total(payment.getTotal())
                .totalPaid(payment.getTotalPaid())
                .paidDate(payment.getPaidDate())
                .bookingId(payment.getBooking().getBookingId())
                .paymentType(payment.getPaymentType().getPaymentTypeName())
                .paymentStatus(payment.getPaymentStatus().getPaymentStatus())
                .build();
    }
    
    public Double calculateTotal(PaymentRequest request) {
        return request.getAmount() +
               (request.getItemCharges() != null ? request.getItemCharges() : 0.0) +
               (request.getServiceCharges() != null ? request.getServiceCharges() : 0.0) -
               (request.getDiscount() != null ? request.getDiscount() : 0.0);
    }
} 