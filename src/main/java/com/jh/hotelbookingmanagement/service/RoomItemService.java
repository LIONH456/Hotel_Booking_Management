package com.jh.hotelbookingmanagement.service;


import com.jh.hotelbookingmanagement.dto.request.RoomItemRequest;
import com.jh.hotelbookingmanagement.dto.response.RoomItemResponse;

import java.util.List;

public interface RoomItemService {
    RoomItemResponse createRoomItem(RoomItemRequest request);
    
    List<RoomItemResponse> getAllRoomItem();

    RoomItemResponse updateRoomItem(Long roomItemId, RoomItemRequest request);

    void deleteRoomItem(Long roomItemId);

    public RoomItemResponse getroomItem(Long roomItemId);
}
