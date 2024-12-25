package com.jh.hotelbookingmanagement.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomItemResponse {
        Long itemId;
        String itemName;
        String description;
        double price;
        int stock;
        boolean active;
}
