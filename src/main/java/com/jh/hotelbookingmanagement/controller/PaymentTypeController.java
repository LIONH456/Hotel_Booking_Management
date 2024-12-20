package com.jh.hotelbookingmanagement.controller;

import com.jh.hotelbookingmanagement.dto.request.ApiResponse;

import com.jh.hotelbookingmanagement.dto.request.PaymentTypeRequest;
import com.jh.hotelbookingmanagement.dto.response.PaymentTypeResponse;
import com.jh.hotelbookingmanagement.service.PaymentTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/paymentType")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PaymentTypeController {
    PaymentTypeService paymentTypeService;

    @PostMapping
    ApiResponse<PaymentTypeResponse> createBooking(@RequestBody PaymentTypeRequest request) {
        return ApiResponse.<PaymentTypeResponse>builder()
                .result(paymentTypeService.createPaymentType(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<PaymentTypeResponse>> getBookings() {
        return ApiResponse.<List<PaymentTypeResponse>>builder()
                .result(paymentTypeService.getAllPaymentType())
                .build();
    }
//
//    @GetMapping("/{bookingId}")
//    BookingResponse getBooking(@PathVariable("bookingId") String bookingId) {
//        return bookingService.getBooking(bookingId);
//    }

    @PutMapping("/{paymentTypeId}")
    PaymentTypeResponse updatePaymentTy(@PathVariable Long paymentTypeId, @RequestBody PaymentTypeRequest request) {
        return paymentTypeService.updatePaymentType(paymentTypeId, request);
    }
//
    @DeleteMapping("/{paymentTypeId}")
    ApiResponse<String> deletePaymentType(@PathVariable Long paymentTypeId) {
        paymentTypeService.deletePaymentType(paymentTypeId);
        return ApiResponse.<String>builder().result("This payment type has been Deleted!").build();
    }
//
//    @GetMapping("/usersId:a{userId}")
//    List<Booking> getBookingsByUser(@PathVariable String userId) {
//        return bookingService.getBookingsByUser(userId);
//    }
}
