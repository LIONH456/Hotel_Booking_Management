package com.jh.hotelbookingmanagement.service;


import com.jh.hotelbookingmanagement.dto.request.RoomItemUsageRequest;
import com.jh.hotelbookingmanagement.dto.response.RoomItemUsageResponse;


import java.util.List;

public interface RoomItemUsageService {
    RoomItemUsageResponse createRoomItemUsage(RoomItemUsageRequest request);
    
    List<RoomItemUsageResponse> getAllRoomItemUsage();

    RoomItemUsageResponse updateRoomItemUsage(String roomItemUsageId, RoomItemUsageRequest request);

    void deleteRoomItemUsage(String roomItemUsageId);
    
}
