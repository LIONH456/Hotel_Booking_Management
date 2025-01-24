package com.jh.hotelbookingmanagement.controller;

import com.jh.hotelbookingmanagement.dto.request.ApiResponse;
import com.jh.hotelbookingmanagement.dto.request.PaymentTypeRequest;
import com.jh.hotelbookingmanagement.dto.response.PaymentTypeResponse;
import com.jh.hotelbookingmanagement.entity.PaymentType;
import com.jh.hotelbookingmanagement.service.PaymentTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment-types")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
@CrossOrigin(origins = "*")
public class PaymentTypeController {
    PaymentTypeService paymentTypeService;

    @PostMapping
    public ApiResponse<PaymentTypeResponse> createPaymentType(@RequestBody PaymentTypeRequest request) {
        return ApiResponse.<PaymentTypeResponse>builder()
                .result(paymentTypeService.createPaymentType(request))
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<PaymentTypeResponse> getPaymentType(@PathVariable Long id) {
        return ApiResponse.<PaymentTypeResponse>builder()
                .result(paymentTypeService.getPaymentTypeById(id))
                .build();
    }

    @GetMapping
    public ApiResponse<List<PaymentTypeResponse>> getAllPaymentTypes() {
        return ApiResponse.<List<PaymentTypeResponse>>builder()
                .result(paymentTypeService.getAllPaymentTypes())
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<PaymentTypeResponse> updatePaymentType(
            @PathVariable Long id,
            @RequestBody PaymentTypeRequest request) {
        return ApiResponse.<PaymentTypeResponse>builder()
                .result(paymentTypeService.updatePaymentType(id, request))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deletePaymentType(@PathVariable Long id) {
        paymentTypeService.deletePaymentType(id);
        return ApiResponse.<String>builder()
                .result("Payment type has been deleted successfully!")
                .build();
    }
}
