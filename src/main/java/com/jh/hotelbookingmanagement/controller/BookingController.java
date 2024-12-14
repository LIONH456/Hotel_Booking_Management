package com.jh.hotelbookingmanagement.controller;

import java.util.List;

import com.jh.hotelbookingmanagement.dto.response.RoomResponse;
import org.springframework.web.bind.annotation.*;

import com.jh.hotelbookingmanagement.dto.request.ApiResponse;
import com.jh.hotelbookingmanagement.dto.request.BookingCreationRequest;
import com.jh.hotelbookingmanagement.dto.request.BookingUpdateRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingResponse;
import com.jh.hotelbookingmanagement.entity.Booking;
import com.jh.hotelbookingmanagement.service.BookingService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookingController {
    BookingService bookingService;

    @PostMapping
    ApiResponse<BookingResponse> createBooking(@RequestBody BookingCreationRequest request) {
        return ApiResponse.<BookingResponse>builder()
                .result(bookingService.createRequest(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<BookingResponse>> getBookings() {
        return ApiResponse.<List<BookingResponse>>builder()
                .result(bookingService.getAllBookings())
                .build();
    }

    @GetMapping("/{bookingId}")
    BookingResponse getBooking(@PathVariable("bookingId") String bookingId) {
        return bookingService.getBooking(bookingId);
    }

    @PutMapping("/{bookingId}")
    BookingResponse updateBooking(@PathVariable String bookingId, @RequestBody BookingUpdateRequest request) {
        return bookingService.updateBooking(bookingId, request);
    }

    @DeleteMapping("/{bookingId}")
    String deleteBooking(@PathVariable String bookingId) {
        bookingService.deleteBooking(bookingId);
        return "Booking has been Deleted!";
    }

    @GetMapping("/usersId:a{userId}")
    List<Booking> getBookingsByUser(@PathVariable String userId) {
        return bookingService.getBookingsByUser(userId);
    }
}
