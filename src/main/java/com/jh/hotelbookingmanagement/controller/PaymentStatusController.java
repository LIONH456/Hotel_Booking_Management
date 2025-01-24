package com.jh.hotelbookingmanagement.controller;

import com.jh.hotelbookingmanagement.dto.request.ApiResponse;
import com.jh.hotelbookingmanagement.dto.request.PaymentStatusRequest;
import com.jh.hotelbookingmanagement.dto.response.PaymentStatusResponse;
import com.jh.hotelbookingmanagement.service.PaymentStatusService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payment-status")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
@CrossOrigin(origins = "*")
public class PaymentStatusController {
    PaymentStatusService paymentStatusService;

    @PostMapping
    public ApiResponse<PaymentStatusResponse> createPaymentStatus(@RequestBody PaymentStatusRequest request) {
        return ApiResponse.<PaymentStatusResponse>builder()
                .result(paymentStatusService.createPaymentStatus(request))
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<PaymentStatusResponse> getPaymentStatus(@PathVariable Long id) {
        return ApiResponse.<PaymentStatusResponse>builder()
                .result(paymentStatusService.getPaymentStatusById(id))
                .build();
    }

    @GetMapping
    public ApiResponse<List<PaymentStatusResponse>> getAllPaymentStatus() {
        return ApiResponse.<List<PaymentStatusResponse>>builder()
                .result(paymentStatusService.getAllPaymentStatus())
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<PaymentStatusResponse> updatePaymentStatus(
            @PathVariable Long id,
            @RequestBody PaymentStatusRequest request) {
        return ApiResponse.<PaymentStatusResponse>builder()
                .result(paymentStatusService.updatePaymentStatus(id, request))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deletePaymentStatus(@PathVariable Long id) {
        paymentStatusService.deletePaymentStatus(id);
        return ApiResponse.<String>builder()
                .result("Payment status has been deleted successfully!")
                .build();
    }
} 