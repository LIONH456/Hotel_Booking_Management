package com.jh.hotelbookingmanagement.controller;

import com.jh.hotelbookingmanagement.dto.request.ApiResponse;
import com.jh.hotelbookingmanagement.dto.request.RateRequest;
import com.jh.hotelbookingmanagement.dto.response.RateResponse;
import com.jh.hotelbookingmanagement.service.RateService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/rate")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RateController {
    RateService rateService;

    @PostMapping
    ApiResponse<RateResponse> createBooking(@RequestBody RateRequest request) {
        return ApiResponse.<RateResponse>builder()
                .result(rateService.createRate(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<RateResponse>> getBookings() {
        return ApiResponse.<List<RateResponse>>builder()
                .result(rateService.getAllRate())
                .build();
    }
//
//    @GetMapping("/{bookingId}")
//    BookingResponse getBooking(@PathVariable("bookingId") String bookingId) {
//        return bookingService.getBooking(bookingId);
//    }

    @PutMapping("/{rateId}")
    RateResponse updateRate(@PathVariable Long rateId, @RequestBody RateRequest request) {
        return rateService.updateRate(rateId, request);
    }
//
    @DeleteMapping("/{rateId}")
    ApiResponse<String> deleteRate(@PathVariable Long rateId) {
        rateService.deleteRate(rateId);
        return ApiResponse.<String>builder().result("This rating has been Deleted!").build();
    }
//
//    @GetMapping("/usersId:a{userId}")
//    List<Booking> getBookingsByUser(@PathVariable String userId) {
//        return bookingService.getBookingsByUser(userId);
//    }
}
