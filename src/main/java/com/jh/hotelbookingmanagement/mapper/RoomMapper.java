package com.jh.hotelbookingmanagement.mapper;

import java.util.List;

import com.jh.hotelbookingmanagement.dto.request.RoomUpdateRequest;
import com.jh.hotelbookingmanagement.dto.request.UserUpdateRequest;
import com.jh.hotelbookingmanagement.entity.User;
import org.mapstruct.Mapper;

import com.jh.hotelbookingmanagement.dto.request.RoomCreationRequest;
import com.jh.hotelbookingmanagement.dto.response.RoomResponse;
import com.jh.hotelbookingmanagement.entity.Room;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    //
    //    void updateBooking(@MappingTarget Booking booking, BookingUpdateRequest request);

    Room toRoom(RoomCreationRequest request);

    RoomResponse toRoomRespone(Room room);

    List<RoomResponse> toRoomRespone(List<Room> rooms);

    void updateRoom(@MappingTarget Room room, RoomUpdateRequest request);
}
