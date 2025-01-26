package com.jh.hotelbookingmanagement.controller;

import com.jh.hotelbookingmanagement.dto.request.ApiResponse;
import com.jh.hotelbookingmanagement.dto.request.BookingStatusRequest;

import com.jh.hotelbookingmanagement.dto.response.BookingStatusResponse;

import com.jh.hotelbookingmanagement.service.BookingStatusService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/bookingStatus")
@CrossOrigin(origins = "http://localhost:5173")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookingStatusController {
    BookingStatusService bookingStatusService;

    @PostMapping
    public ApiResponse<BookingStatusResponse> createBookingStatus(@RequestBody BookingStatusRequest request) {
        return ApiResponse.<BookingStatusResponse>builder()
                .result(bookingStatusService.createBookingStatus(request))
                .build();
    }

    @GetMapping
    public ApiResponse<List<BookingStatusResponse>> getAllBookingStatuses() {
        return ApiResponse.<List<BookingStatusResponse>>builder()
                .result(bookingStatusService.getAllBookingStatus())
                .build();
    }

    @PutMapping("/{bookingStatusId}")
    public ApiResponse<BookingStatusResponse> updateBookingStatus(
            @PathVariable Long bookingStatusId,
            @RequestBody BookingStatusRequest request) {
        return ApiResponse.<BookingStatusResponse>builder()
                .result(bookingStatusService.updateBookingStatus(bookingStatusId, request))
                .build();
    }

    @DeleteMapping("/{bookingStatusId}")
    public ApiResponse<String> deleteBookingStatus(@PathVariable Long bookingStatusId) {
        bookingStatusService.deleteBookingStatus(bookingStatusId);
        return ApiResponse.<String>builder()
                .result("Booking status deleted successfully")
                .build();
    }
}
