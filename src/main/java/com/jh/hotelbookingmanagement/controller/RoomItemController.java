package com.jh.hotelbookingmanagement.controller;

import com.jh.hotelbookingmanagement.dto.request.ApiResponse;
import com.jh.hotelbookingmanagement.dto.request.RoomItemRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingDetailResponse;
import com.jh.hotelbookingmanagement.dto.response.RoomItemResponse;
import com.jh.hotelbookingmanagement.service.RoomItemService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/roomItem")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoomItemController {
    RoomItemService roomItemService;

    @PostMapping
    ApiResponse<RoomItemResponse> createBooking(@RequestBody RoomItemRequest request) {
        return ApiResponse.<RoomItemResponse>builder()
                .result(roomItemService.createRoomItem(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<RoomItemResponse>> getBookings() {
        return ApiResponse.<List<RoomItemResponse>>builder()
                .result(roomItemService.getAllRoomItem())
                .build();
    }
//
//    @GetMapping("/{bookingId}")
//    BookingResponse getBooking(@PathVariable("bookingId") String bookingId) {
//        return bookingService.getBooking(bookingId);
//    }

    @PutMapping("/{roomItemId}")
    RoomItemResponse updateRoomItem(@PathVariable Long roomItemId, @RequestBody RoomItemRequest request) {
        return roomItemService.updateRoomItem(roomItemId, request);
    }
//
    @DeleteMapping("/{roomItemId}")
    ApiResponse<String> deleteRoomItem(@PathVariable Long roomItemId) {
        roomItemService.deleteRoomItem(roomItemId);
        return ApiResponse.<String>builder().result("This room item has been Deleted!").build();
    }

    @GetMapping("/{roomItemId}")
    ApiResponse<RoomItemResponse> getBooking(@PathVariable("roomItemId") Long roomItemId) {
        return ApiResponse.<RoomItemResponse>builder()
                .result(roomItemService.getRoomItem(roomItemId))
                .build();
    }
}
