package com.jh.hotelbookingmanagement.controller;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.*;

import com.jh.hotelbookingmanagement.dto.request.ApiResponse;
import com.jh.hotelbookingmanagement.dto.request.BookingCreationRequest;
import com.jh.hotelbookingmanagement.dto.request.BookingUpdateRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingResponse;
import com.jh.hotelbookingmanagement.dto.response.RoomResponse;
import com.jh.hotelbookingmanagement.entity.Booking;
import com.jh.hotelbookingmanagement.service.implement.BookingService;

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
    public ApiResponse<BookingResponse> createBooking(@RequestBody BookingCreationRequest request) {
        return ApiResponse.<BookingResponse>builder()
                .result(bookingService.createBooking(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<BookingResponse>> getBookings() {
        return ApiResponse.<List<BookingResponse>>builder()
                .result(bookingService.getAllBookings())
                .build();
    }

    @GetMapping("/{bookingId}")
    public ApiResponse<BookingResponse> getBooking(@PathVariable("bookingId") String bookingId) {
        log.info("Fetching booking with ID: {}", bookingId);
        BookingResponse booking = bookingService.getBooking(bookingId);
        log.info("Found booking: {}", booking);
        return ApiResponse.<BookingResponse>builder()
                .result(booking)
                .build();
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

    @GetMapping("/branch/{branchId}/available-rooms")
    public ApiResponse<List<RoomResponse>> getAvailableRoomsByBranch(
        @PathVariable String branchId,
        @RequestParam LocalDateTime checkIn,
        @RequestParam LocalDateTime checkOut) {
        return ApiResponse.<List<RoomResponse>>builder()
            .result(bookingService.getAvailableRoomsByBranch(branchId, checkIn, checkOut))
            .build();
    }
}
