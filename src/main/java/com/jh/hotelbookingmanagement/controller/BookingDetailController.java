package com.jh.hotelbookingmanagement.controller;

import com.jh.hotelbookingmanagement.dto.request.ApiResponse;
import com.jh.hotelbookingmanagement.dto.request.BookingDetailRequest;
import com.jh.hotelbookingmanagement.dto.request.BookingDetailUpdateRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingDetailResponse;
import com.jh.hotelbookingmanagement.dto.response.BookingResponse;
import com.jh.hotelbookingmanagement.service.BookingDetailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/bookingdetails")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookingDetailController {
    BookingDetailService bookingDetailService;

    @PostMapping("/{bookingId}")
    public ApiResponse<BookingDetailResponse> createBookingDetail(
            @PathVariable String bookingId,
            @RequestBody BookingDetailRequest request) {
        return ApiResponse.<BookingDetailResponse>builder()
                .result(bookingDetailService.createBookingDetail(bookingId, request))
                .build();
    }

    @GetMapping
    ApiResponse<List<BookingDetailResponse>> getBookings() {
        return ApiResponse.<List<BookingDetailResponse>>builder()
                .result(bookingDetailService.getBookingDetails())
                .build();
    }

    @GetMapping("/{bookingDetailId}")
    ApiResponse<BookingDetailResponse> getBooking(@PathVariable("bookingDetailId") String bookingDetailId) {
        return ApiResponse.<BookingDetailResponse>builder()
                .result(bookingDetailService.getBookingDetail(bookingDetailId))
                .build();
    }

    @PutMapping("/{bookingDetailId}")
    ApiResponse<BookingDetailResponse> updateBooking(@PathVariable String bookingDetailId, @RequestBody BookingDetailUpdateRequest request) {
        return ApiResponse.<BookingDetailResponse>builder()
                .result(bookingDetailService.updateBookingDetail(bookingDetailId, request))
                .build();
    }

    @DeleteMapping("/{bookingId}")
    ApiResponse<String> deleteBooking(@PathVariable String bookingId) {
        bookingDetailService.deleteBookingDetail(bookingId);
        return ApiResponse.<String>builder().result("Booking has been Deleted!").build();
    }
//
//    @GetMapping("/usersId:a{userId}")
//    List<Booking> getBookingsByUser(@PathVariable String userId) {
//        return bookingService.getBookingsByUser(userId);
//    }
}
