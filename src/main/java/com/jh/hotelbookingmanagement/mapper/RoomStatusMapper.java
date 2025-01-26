package com.jh.hotelbookingmanagement.mapper;

import com.jh.hotelbookingmanagement.dto.request.RoomStatusRequest;
import com.jh.hotelbookingmanagement.dto.response.RoomStatusResponse;
import com.jh.hotelbookingmanagement.entity.RoomStatus;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoomStatusMapper {
    RoomStatus toRoomStatus(RoomStatusRequest request);
    RoomStatusResponse toRoomStatusResponse(RoomStatus roomStatus);
    void updateRoomStatus(@MappingTarget RoomStatus roomStatus, RoomStatusRequest request);
} 