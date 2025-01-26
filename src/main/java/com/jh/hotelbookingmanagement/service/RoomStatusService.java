package com.jh.hotelbookingmanagement.service;

import com.jh.hotelbookingmanagement.dto.request.RoomStatusRequest;
import com.jh.hotelbookingmanagement.dto.response.RoomStatusResponse;
import java.util.List;

public interface RoomStatusService {
    RoomStatusResponse createRoomStatus(RoomStatusRequest request);
    List<RoomStatusResponse> getAllRoomStatus();
    RoomStatusResponse updateRoomStatus(Long statusId, RoomStatusRequest request);
    void deleteRoomStatus(Long statusId);
    RoomStatusResponse getRoomStatusById(Long statusId);
} 