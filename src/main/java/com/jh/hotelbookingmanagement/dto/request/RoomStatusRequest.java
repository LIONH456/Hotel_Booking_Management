package com.jh.hotelbookingmanagement.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class RoomStatusRequest {
    String roomStatusName;
    String description;
} 