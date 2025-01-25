package com.jh.hotelbookingmanagement.dto.request;

import com.jh.hotelbookingmanagement.entity.RoomStatus;
import com.jh.hotelbookingmanagement.entity.RoomType;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomCreationRequest {
    String roomNumber;
    Long roomStatusId;
    Long roomTypeId;
    String branchId;
    String description;
    double price;
}
