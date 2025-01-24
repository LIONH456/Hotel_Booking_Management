package com.jh.hotelbookingmanagement.service.implement;

import com.jh.hotelbookingmanagement.dto.request.PaymentRequest;
import com.jh.hotelbookingmanagement.dto.response.PaymentResponse;
import com.jh.hotelbookingmanagement.entity.Payment;
import com.jh.hotelbookingmanagement.entity.PaymentStatus;
import com.jh.hotelbookingmanagement.entity.PaymentType;
import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import com.jh.hotelbookingmanagement.mapper.PaymentMapper;

import com.jh.hotelbookingmanagement.repository.BookingRepository;
import com.jh.hotelbookingmanagement.repository.PaymentRepository;
import com.jh.hotelbookingmanagement.repository.PaymentStatusRepository;
import com.jh.hotelbookingmanagement.repository.PaymentTypeRepository;
import com.jh.hotelbookingmanagement.service.PaymentService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Builder
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;
    private final PaymentTypeRepository paymentTypeRepository;
    private final PaymentStatusRepository paymentStatusRepository;
    private final PaymentMapper paymentMapper;

    @Override
    @Transactional
    public PaymentResponse createPayment(PaymentRequest request) {
        var booking = bookingRepository.findById(request.getBookingId())
                .orElseThrow(() -> new AppException(ErrorCode.BOOKING_NOT_FOUND));
        
        var paymentType = paymentTypeRepository.findById(request.getPaymentTypeId())
                .orElseThrow(() -> new AppException(ErrorCode.PAYMENT_TYPE_NOT_FOUND));
        
        var paymentStatus = paymentStatusRepository.findById(request.getPaymentStatusId())
                .orElseThrow(() -> new AppException(ErrorCode.PAYMENT_STATUS_NOT_FOUND));

        var payment = paymentMapper.toEntity(request, booking, paymentType, paymentStatus);
        var savedPayment = paymentRepository.save(payment);
        return paymentMapper.toResponse(savedPayment);
    }

    @Override
    public PaymentResponse getPaymentById(String paymentId) {
        var payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new AppException(ErrorCode.PAYMENT_NOT_FOUND));
        return paymentMapper.toResponse(payment);
    }

    @Override
    public List<PaymentResponse> getAllPayments() {
        return paymentRepository.findAll().stream()
                .map(paymentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PaymentResponse updatePayment(String paymentId, PaymentRequest request) {
        var payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new AppException(ErrorCode.PAYMENT_NOT_FOUND));

        var paymentType = paymentTypeRepository.findById(request.getPaymentTypeId())
                .orElseThrow(() -> new AppException(ErrorCode.PAYMENT_TYPE_NOT_FOUND));
        
        var paymentStatus = paymentStatusRepository.findById(request.getPaymentStatusId())
                .orElseThrow(() -> new AppException(ErrorCode.PAYMENT_STATUS_NOT_FOUND));

        payment.setAmount(request.getAmount());
        payment.setDiscount(request.getDiscount());
        payment.setItemCharges(request.getItemCharges());
        payment.setServiceCharges(request.getServiceCharges());
        payment.setTotal(paymentMapper.calculateTotal(request));
        payment.setTotalPaid(request.getAmount());
        payment.setPaymentType(paymentType);
        payment.setPaymentStatus(paymentStatus);

        var updatedPayment = paymentRepository.save(payment);
        return paymentMapper.toResponse(updatedPayment);
    }

    @Override
    @Transactional
    public void deletePayment(String paymentId) {
        if (!paymentRepository.existsById(paymentId)) {
            throw new AppException(ErrorCode.PAYMENT_NOT_FOUND);
        }
        paymentRepository.deleteById(paymentId);
    }

    @Override
    public List<PaymentResponse> getPaymentsByBookingId(String bookingId) {
        return paymentRepository.findByBookingBookingId(bookingId).stream()
                .map(paymentMapper::toResponse)
                .collect(Collectors.toList());
    }
} 