package com.jh.hotelbookingmanagement.dto.response;

import jakarta.persistence.*;

import com.jh.hotelbookingmanagement.entity.RoomStatus;
import com.jh.hotelbookingmanagement.entity.RoomType;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class RoomResponse {
    String roomId;
    String roomNumber;
    RoomStatus roomStatusId;
    RoomType roomTypeId;
    String branchId;
    String description;
    double price;
}
