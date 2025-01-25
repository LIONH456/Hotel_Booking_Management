package com.jh.hotelbookingmanagement.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class RoomTypeResponse {
    String roomTypeId;
    String roomTypeName;
    String description;
    String occupancy;
    int bedCount;
    boolean active;
} 