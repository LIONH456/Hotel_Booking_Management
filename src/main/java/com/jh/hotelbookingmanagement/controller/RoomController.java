package com.jh.hotelbookingmanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.jh.hotelbookingmanagement.dto.request.ApiResponse;
import com.jh.hotelbookingmanagement.dto.request.RoomCreationRequest;
import com.jh.hotelbookingmanagement.dto.request.RoomUpdateRequest;
import com.jh.hotelbookingmanagement.dto.response.RoomResponse;
import com.jh.hotelbookingmanagement.service.Implement.RoomService;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder
public class RoomController {
    RoomService roomService;

    @PostMapping
    public ApiResponse<RoomResponse> createRoom(@RequestBody RoomCreationRequest request) {
        return ApiResponse.<RoomResponse>builder()
                .result(roomService.createRoom(request))
                .build();
    }

    @GetMapping
    public ApiResponse<List<RoomResponse>> getAllRoom() {
        return ApiResponse.<List<RoomResponse>>builder()
                .result(roomService.getAllRoom())
                .build();
    }

    @GetMapping("/")
    public ApiResponse<List<RoomResponse>> getAllRoomsByUser(@RequestParam String branchId) {
        // String managerId = principal.getName(); // Assuming the manager's ID is stored in the Principal
        return ApiResponse.<List<RoomResponse>>builder()
                .result(roomService.getAllRoomByUser(branchId))
                .build();
    }

    @DeleteMapping("/{roomId}")
    public ApiResponse<String> deleteRoom(@PathVariable String roomId) {

        roomService.deleteRoomById(roomId);
        return ApiResponse.<String>builder().result("Room has been deleted").build();
    }

    @PutMapping("/{roomId}")
    public ApiResponse<RoomResponse> updateRoom(@PathVariable String roomId, @RequestBody RoomUpdateRequest request) {
        return ApiResponse.<RoomResponse>builder()
                .result(roomService.updateRoom(roomId, request))
                .build();
    }

    @GetMapping("/{roomId}")
    public ApiResponse<RoomResponse> getRoomById(@PathVariable String roomId) {
        return ApiResponse.<RoomResponse>builder()
                .result(roomService.getRoomById(roomId))
                .build();
    }
}
