package com.jh.hotelbookingmanagement.controller;

import com.jh.hotelbookingmanagement.dto.request.ApiResponse;
import com.jh.hotelbookingmanagement.dto.request.PaymentRequest;
import com.jh.hotelbookingmanagement.dto.response.PaymentResponse;
import com.jh.hotelbookingmanagement.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AccessLevel;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PaymentController {
    PaymentService paymentService;

    @PostMapping
    public ApiResponse<PaymentResponse> createPayment(@RequestBody PaymentRequest request) {
        return ApiResponse.<PaymentResponse>builder()
                .result(paymentService.createPayment(request))
                .build();
    }

    @GetMapping("/{paymentId}")
    public ApiResponse<PaymentResponse> getPayment(@PathVariable String paymentId) {
        return ApiResponse.<PaymentResponse>builder()
                .result(paymentService.getPaymentById(paymentId))
                .build();
    }

    @GetMapping
    public ApiResponse<List<PaymentResponse>> getAllPayments() {
        return ApiResponse.<List<PaymentResponse>>builder()
                .result(paymentService.getAllPayments())
                .build();
    }

    @PutMapping("/{paymentId}")
    public ApiResponse<PaymentResponse> updatePayment(
            @PathVariable String paymentId,
            @RequestBody PaymentRequest request) {
        return ApiResponse.<PaymentResponse>builder()
                .result(paymentService.updatePayment(paymentId, request))
                .build();
    }

    @DeleteMapping("/{paymentId}")
    public ApiResponse<String> deletePayment(@PathVariable String paymentId) {
        paymentService.deletePayment(paymentId);
        return ApiResponse.<String>builder()
                .result("Payment has been deleted successfully!")
                .build();
    }

    @GetMapping("/booking/{bookingId}")
    public ApiResponse<List<PaymentResponse>> getPaymentsByBooking(@PathVariable String bookingId) {
        return ApiResponse.<List<PaymentResponse>>builder()
                .result(paymentService.getPaymentsByBookingId(bookingId))
                .build();
    }
} 