package com.jh.hotelbookingmanagement.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class RoomStatusResponse {
    Long roomStatusId;
    String roomStatusName;
    String description;
} 