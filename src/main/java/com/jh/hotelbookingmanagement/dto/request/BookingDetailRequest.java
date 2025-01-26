package com.jh.hotelbookingmanagement.dto.request;

import com.jh.hotelbookingmanagement.entity.Booking;
import com.jh.hotelbookingmanagement.entity.BookingStatus;
import com.jh.hotelbookingmanagement.entity.Promotion;
import com.jh.hotelbookingmanagement.entity.Room;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingDetailRequest {
    String roomId;
    LocalDateTime checkInDate;
    LocalDateTime checkOutDate;
    Integer adult;
    Integer child;
}
