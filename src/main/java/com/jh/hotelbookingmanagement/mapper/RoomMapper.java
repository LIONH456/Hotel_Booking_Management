package com.jh.hotelbookingmanagement.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.jh.hotelbookingmanagement.dto.request.RoomCreationRequest;
import com.jh.hotelbookingmanagement.dto.request.RoomUpdateRequest;
import com.jh.hotelbookingmanagement.dto.response.RoomResponse;
import com.jh.hotelbookingmanagement.entity.Room;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    @Mapping(target = "branchId", ignore = true)
    Room toRoom(RoomCreationRequest request);

    @Mapping(target = "branchId", ignore = true)
    RoomResponse toRoomRespone(Room room);

    List<RoomResponse> toRoomRespone(List<Room> rooms);

    @Mapping(target = "branchId", ignore = true)
    void updateRoom(@MappingTarget Room room, RoomUpdateRequest request);
}
