package com.jh.hotelbookingmanagement.mapper;

import com.jh.hotelbookingmanagement.dto.request.RoomTypeRequest;
import com.jh.hotelbookingmanagement.dto.response.RoomTypeResponse;
import com.jh.hotelbookingmanagement.entity.RoomType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoomTypeMapper {
    RoomType toRoomType(RoomTypeRequest request);
    RoomTypeResponse toRoomTypeResponse(RoomType roomType);
    void updateRoomType(@MappingTarget RoomType roomType, RoomTypeRequest request);
} 