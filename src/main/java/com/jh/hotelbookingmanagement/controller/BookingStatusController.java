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
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookingStatusController {
    BookingStatusService bookingStatusService;

    @PostMapping
    ApiResponse<BookingStatusResponse> createBooking(@RequestBody BookingStatusRequest request) {
        return ApiResponse.<BookingStatusResponse>builder().result(bookingStatusService.createBookingStatus(request)).build();
    }

    @GetMapping
    ApiResponse<List<BookingStatusResponse>> getBookings() {
        return ApiResponse.<List<BookingStatusResponse>>builder()
                .result(bookingStatusService.getAllBookingStatus())
                .build();
    }
//
//    @GetMapping("/{bookingId}")
//    BookingResponse getBooking(@PathVariable("bookingId") String bookingId) {
//        return bookingService.getBooking(bookingId);
//    }

    @PutMapping("/{bookingStatusId}")
    BookingStatusResponse updatebookingStatus(@PathVariable Long bookingStatusId, @RequestBody BookingStatusRequest request) {
        return bookingStatusService.updateBookingStatus(bookingStatusId, request);
    }
//
    @DeleteMapping("/{bookingStatusId}")
    ApiResponse<String> deletebookingStatus(@PathVariable Long bookingStatusId) {
        bookingStatusService.deleteBookingStatus(bookingStatusId);
        return ApiResponse.<String>builder().result("This booking status has been Deleted!").build();
    }
//
//    @GetMapping("/usersId:a{userId}")
//    List<Booking> getBookingsByUser(@PathVariable String userId) {
//        return bookingService.getBookingsByUser(userId);
//    }
}
