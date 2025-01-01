package com.jh.hotelbookingmanagement.dto.request;


import jakarta.validation.constraints.Min;
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
        @Min(value = 1, message = "INSUFFICIENT_STOCK")
        int stock;
        boolean active;
}
