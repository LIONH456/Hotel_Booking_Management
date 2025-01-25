package com.jh.hotelbookingmanagement.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class BookingDetailResponse {
    String bookingDetailId;
    String bookingId;
    LocalDateTime checkInDate;
    LocalDateTime checkOutDate;
    Integer adult;
    Integer child;
    String roomId;
    BigDecimal totalAmount;
    String bookingStatus;
}
