package com.jh.hotelbookingmanagement.controller;

import com.jh.hotelbookingmanagement.dto.request.ApiResponse;
import com.jh.hotelbookingmanagement.dto.request.RoomStatusRequest;
import com.jh.hotelbookingmanagement.dto.response.RoomStatusResponse;
import com.jh.hotelbookingmanagement.service.RoomStatusService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/roomStatus")
public class RoomStatusController {
    RoomStatusService roomStatusService;

    @PostMapping
    ApiResponse<RoomStatusResponse> createRoomStatus(@RequestBody RoomStatusRequest request) {
        return ApiResponse.<RoomStatusResponse>builder()
                .result(roomStatusService.createRoomStatus(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<RoomStatusResponse>> getRoomStatuses() {
        return ApiResponse.<List<RoomStatusResponse>>builder()
                .result(roomStatusService.getAllRoomStatus())
                .build();
    }

    @PutMapping("/{statusId}")
    ApiResponse<RoomStatusResponse> updateRoomStatus(@PathVariable Long statusId, @RequestBody RoomStatusRequest request) {
        return ApiResponse.<RoomStatusResponse>builder()
                .result(roomStatusService.updateRoomStatus(statusId, request))
                .build();
    }

    @DeleteMapping("/{statusId}")
    ApiResponse<String> deleteRoomStatus(@PathVariable Long statusId) {
        roomStatusService.deleteRoomStatus(statusId);
        return ApiResponse.<String>builder().result("Room status has been deleted").build();
    }

    @GetMapping("/{statusId}")
    ApiResponse<RoomStatusResponse> getRoomStatusById(@PathVariable Long statusId) {
        return ApiResponse.<RoomStatusResponse>builder()
                .result(roomStatusService.getRoomStatusById(statusId))
                .build();
    }
} 