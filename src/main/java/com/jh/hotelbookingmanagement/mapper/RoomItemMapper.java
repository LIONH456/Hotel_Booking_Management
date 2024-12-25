package com.jh.hotelbookingmanagement.mapper;

import com.jh.hotelbookingmanagement.dto.request.RoomCreationRequest;
import com.jh.hotelbookingmanagement.dto.request.RoomItemRequest;
import com.jh.hotelbookingmanagement.dto.request.RoomUpdateRequest;

import com.jh.hotelbookingmanagement.dto.response.RoomItemResponse;
import com.jh.hotelbookingmanagement.dto.response.RoomResponse;

import com.jh.hotelbookingmanagement.entity.Room;
import com.jh.hotelbookingmanagement.entity.RoomItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoomItemMapper {
    RoomItem toRoomItem(RoomItemRequest request);
    RoomItemResponse toRoomItemResponse(RoomItem roomItem);
    void updateRoomItem(@MappingTarget RoomItem roomItem, RoomItemRequest request);
}
