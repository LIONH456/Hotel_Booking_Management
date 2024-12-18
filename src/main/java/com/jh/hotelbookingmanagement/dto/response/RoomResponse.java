package com.jh.hotelbookingmanagement.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jh.hotelbookingmanagement.entity.Room;
import jakarta.persistence.*;

import com.jh.hotelbookingmanagement.entity.RoomStatus;
import com.jh.hotelbookingmanagement.entity.RoomType;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomResponse {
    String roomId;
    String roomNumber;
    RoomStatus roomStatusId;
    RoomType roomTypeId;
    String branchId;
    String description;
    double price;


    public static RoomResponse fromRoom(Room room) {
        log.info(room.getBranch().getBranchId());
        return RoomResponse.builder()
                .roomId(room.getRoomId())
                .roomNumber(room.getRoomNumber())
                .roomTypeId(room.getRoomTypeId())
                .roomStatusId(room.getRoomStatusId())
                .branchId(room.getBranch().getBranchId())
                .description(room.getDescription())
                .price(room.getPrice())
                .build();
    }
}
