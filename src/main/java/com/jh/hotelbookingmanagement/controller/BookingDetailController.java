package com.jh.hotelbookingmanagement.controller;

import com.jh.hotelbookingmanagement.dto.request.ApiResponse;
import com.jh.hotelbookingmanagement.dto.request.BookingDetailRequest;
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
@RequestMapping("/bookingsDetails")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookingDetailController {
    BookingDetailService bookingDetailService;

    @PostMapping
    ApiResponse<BookingDetailResponse> createBooking(@RequestBody BookingDetailRequest request) {
        return ApiResponse.<BookingDetailResponse>builder()
                .result(bookingDetailService.createBookingDetail(request))
                .build();
    }

//    @GetMapping
//    ApiResponse<List<BookingResponse>> getBookings() {
//        return ApiResponse.<List<BookingResponse>>builder()
//                .result(bookingService.getAllBookings())
//                .build();
//    }
//
//    @GetMapping("/{bookingId}")
//    BookingResponse getBooking(@PathVariable("bookingId") String bookingId) {
//        return bookingService.getBooking(bookingId);
//    }
//
//    @PutMapping("/{bookingId}")
//    BookingResponse updateBooking(@PathVariable String bookingId, @RequestBody BookingUpdateRequest request) {
//        return bookingService.updateBooking(bookingId, request);
//    }
//
//    @DeleteMapping("/{bookingId}")
//    String deleteBooking(@PathVariable String bookingId) {
//        bookingService.deleteBooking(bookingId);
//        return "Booking has been Deleted!";
//    }
//
//    @GetMapping("/usersId:a{userId}")
//    List<Booking> getBookingsByUser(@PathVariable String userId) {
//        return bookingService.getBookingsByUser(userId);
//    }
}
