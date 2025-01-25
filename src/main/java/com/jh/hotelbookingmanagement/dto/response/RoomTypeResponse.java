package com.jh.hotelbookingmanagement.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomTypeResponse {
    int roomTypeId;
    String roomTypeName;
    String description;
    String occupancy;
    int bedCount;
    boolean active;
} 