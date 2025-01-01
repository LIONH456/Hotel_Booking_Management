package com.jh.hotelbookingmanagement.controller;

import com.jh.hotelbookingmanagement.dto.request.ApiResponse;
import com.jh.hotelbookingmanagement.dto.request.ServiceUsageRequest;
import com.jh.hotelbookingmanagement.dto.response.ServiceUsageResponse;
import com.jh.hotelbookingmanagement.service.ServiceUsageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/serviceUsage")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ServiceUsageController {
    ServiceUsageService serviceUsageService;

    @PostMapping
    ApiResponse<ServiceUsageResponse> createBooking(@RequestBody ServiceUsageRequest request) {
        return ApiResponse.<ServiceUsageResponse>builder()
                .result(serviceUsageService.createServiceUsage(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<ServiceUsageResponse>> getBookings() {
        return ApiResponse.<List<ServiceUsageResponse>>builder()
                .result(serviceUsageService.getAllServiceUsage())
                .build();
    }
//
//    @GetMapping("/{bookingId}")
//    BookingResponse getBooking(@PathVariable("bookingId") String bookingId) {
//        return bookingService.getBooking(bookingId);
//    }

    @PutMapping("/{serviceUsageId}")
    ServiceUsageResponse updateServiceUsage(@PathVariable String serviceUsageId, @RequestBody ServiceUsageRequest request) {
        return serviceUsageService.updateServiceUsage(serviceUsageId, request);
    }
//
    @DeleteMapping("/{serviceUsageId}")
    ApiResponse<String> deleteServiceUsage(@PathVariable String serviceUsageId) {
        serviceUsageService.deleteServiceUsage(serviceUsageId);
        return ApiResponse.<String>builder().result("This room item usage has been Deleted!").build();
    }
//
//    @GetMapping("/usersId:a{userId}")
//    List<Booking> getBookingsByUser(@PathVariable String userId) {
//        return bookingService.getBookingsByUser(userId);
//    }
}
