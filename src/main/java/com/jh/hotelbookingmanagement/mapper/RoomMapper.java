package com.jh.hotelbookingmanagement.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.jh.hotelbookingmanagement.dto.request.RoomCreationRequest;
import com.jh.hotelbookingmanagement.dto.request.RoomUpdateRequest;
import com.jh.hotelbookingmanagement.dto.response.RoomResponse;
import com.jh.hotelbookingmanagement.entity.Room;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    Room toRoom(RoomCreationRequest request);

    RoomResponse toRoomRespone(Room room);

    List<RoomResponse> toRoomRespone(List<Room> rooms);

    void updateRoom(@MappingTarget Room room, RoomUpdateRequest request);
}
