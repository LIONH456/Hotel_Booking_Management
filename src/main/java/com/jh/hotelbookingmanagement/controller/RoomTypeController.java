package com.jh.hotelbookingmanagement.controller;

import com.jh.hotelbookingmanagement.dto.request.ApiResponse;
import com.jh.hotelbookingmanagement.dto.request.RoomTypeRequest;
import com.jh.hotelbookingmanagement.dto.response.RoomTypeResponse;
import com.jh.hotelbookingmanagement.service.RoomTypeService;
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
public class RoomTypeController {
    RoomTypeService roomTypeService;

    @PostMapping
    ApiResponse<RoomTypeResponse> createRoomType(@RequestBody RoomTypeRequest request) {
        return ApiResponse.<RoomTypeResponse>builder()
                .result(roomTypeService.createRoomType(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<RoomTypeResponse>> getRoomTypes() {
        return ApiResponse.<List<RoomTypeResponse>>builder()
                .result(roomTypeService.getAllRoomType())
                .build();
    }

    @PutMapping("/{roomTypeId}")
    RoomTypeResponse updateRoomType(@PathVariable Long roomTypeId, @RequestBody RoomTypeRequest request) {
        return roomTypeService.updateRoomType(roomTypeId, request);
    }

    @DeleteMapping("/{roomTypeId}")
    ApiResponse<String> deleteRoomType(@PathVariable Long roomTypeId) {
        roomTypeService.deleteRoomType(roomTypeId);
        return ApiResponse.<String>builder().result("This room type has been Deleted!").build();
    }
} 