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

    @Mapping(target = "branch", ignore = true)
    @Mapping(target = "roomStatusId", ignore = true)
    @Mapping(target = "roomTypeId", ignore = true)
    Room toRoom(RoomCreationRequest request);

    @Mapping(target = "branchId", source = "branch.branchId")
    RoomResponse toRoomRespone(Room room);

    List<RoomResponse> toRoomRespone(List<Room> rooms);

    @Mapping(target = "branch", ignore = true)
    @Mapping(target = "roomStatusId", ignore = true)
    @Mapping(target = "roomTypeId", ignore = true)
    void updateRoom(@MappingTarget Room room, RoomUpdateRequest request);
}
