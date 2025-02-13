package com.jh.hotelbookingmanagement.controller;

import com.jh.hotelbookingmanagement.dto.request.ApiResponse;
import com.jh.hotelbookingmanagement.dto.request.BookingMethodRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingMethodResponse;
import com.jh.hotelbookingmanagement.service.BookingMethodService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/bookingMethod")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookingMethodController {
    BookingMethodService bookingMethodService;

    @PostMapping
    ApiResponse<BookingMethodResponse> createBooking(@RequestBody BookingMethodRequest request) {
        return ApiResponse.<BookingMethodResponse>builder()
                .result(bookingMethodService.createBookingMethod(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<BookingMethodResponse>> getBookings() {
        return ApiResponse.<List<BookingMethodResponse>>builder()
                .result(bookingMethodService.getAllBookingMethod())
                .build();
    }
//
//    @GetMapping("/{bookingId}")
//    BookingResponse getBooking(@PathVariable("bookingId") String bookingId) {
//        return bookingService.getBooking(bookingId);
//    }

    @PutMapping("/{bookingMethodId}")
    BookingMethodResponse updateBookingMethod(@PathVariable Long bookingMethodId, @RequestBody BookingMethodRequest request) {
        return bookingMethodService.updateBookingMethod(bookingMethodId, request);
    }
//
    @DeleteMapping("/{bookingMethodId}")
    ApiResponse<String> deleteBookingMethod(@PathVariable Long bookingMethodId) {
        bookingMethodService.deleteBookingMethod(bookingMethodId);
        return ApiResponse.<String>builder().result("This booking method has been Deleted!").build();
    }
//
//    @GetMapping("/usersId:a{userId}")
//    List<Booking> getBookingsByUser(@PathVariable String userId) {
//        return bookingService.getBookingsByUser(userId);
//    }
}
