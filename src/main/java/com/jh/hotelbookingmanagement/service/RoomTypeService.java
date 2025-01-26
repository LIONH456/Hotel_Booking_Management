package com.jh.hotelbookingmanagement.service;

import com.jh.hotelbookingmanagement.dto.request.RoomTypeRequest;
import com.jh.hotelbookingmanagement.dto.response.RoomTypeResponse;

import java.util.List;

public interface RoomTypeService {
    RoomTypeResponse createRoomType(RoomTypeRequest request);
    
    List<RoomTypeResponse> getAllRoomType();

    RoomTypeResponse updateRoomType(Long roomTypeId, RoomTypeRequest request);

    void deleteRoomType(Long roomTypeId);

    RoomTypeResponse getRoomTypeById(Long roomTypeId);
} 