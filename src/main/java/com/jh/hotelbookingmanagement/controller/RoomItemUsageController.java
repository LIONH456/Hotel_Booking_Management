package com.jh.hotelbookingmanagement.controller;

import com.jh.hotelbookingmanagement.dto.request.ApiResponse;
import com.jh.hotelbookingmanagement.dto.request.RoomItemUsageRequest;
import com.jh.hotelbookingmanagement.dto.response.RoomItemUsageResponse;
import com.jh.hotelbookingmanagement.service.RoomItemUsageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/roomItemUsage")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoomItemUsageController {
    RoomItemUsageService roomItemUsageService;

    @PostMapping
    ApiResponse<RoomItemUsageResponse> createBooking(@RequestBody RoomItemUsageRequest request) {
        return ApiResponse.<RoomItemUsageResponse>builder()
                .result(roomItemUsageService.createRoomItemUsage(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<RoomItemUsageResponse>> getBookings() {
        return ApiResponse.<List<RoomItemUsageResponse>>builder()
                .result(roomItemUsageService.getAllRoomItemUsage())
                .build();
    }
//
//    @GetMapping("/{bookingId}")
//    BookingResponse getBooking(@PathVariable("bookingId") String bookingId) {
//        return bookingService.getBooking(bookingId);
//    }

    @PutMapping("/{roomItemUsageId}")
    RoomItemUsageResponse updateRoomItemUsage(@PathVariable String roomItemUsageId, @RequestBody RoomItemUsageRequest request) {
        return roomItemUsageService.updateRoomItemUsage(roomItemUsageId, request);
    }
//
    @DeleteMapping("/{roomItemUsageId}")
    ApiResponse<String> deleteRoomItemUsage(@PathVariable String roomItemUsageId) {
        roomItemUsageService.deleteRoomItemUsage(roomItemUsageId);
        return ApiResponse.<String>builder().result("This room item usage has been Deleted!").build();
    }
//
//    @GetMapping("/usersId:a{userId}")
//    List<Booking> getBookingsByUser(@PathVariable String userId) {
//        return bookingService.getBookingsByUser(userId);
//    }
}
