package com.jh.hotelbookingmanagement.dto.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomItemRequest {
        String itemName;
        String description;
        double price;
        int stock;
        boolean active;
}
