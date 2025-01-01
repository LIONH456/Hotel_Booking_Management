package com.jh.hotelbookingmanagement.dto.response;

import com.jh.hotelbookingmanagement.entity.BookingDetail;
import com.jh.hotelbookingmanagement.entity.RoomItem;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomItemUsageResponse {
    String itemUsageId;
    String bookingDetailId;
    int quantity;
    double charge;
    RoomItem item;
}
