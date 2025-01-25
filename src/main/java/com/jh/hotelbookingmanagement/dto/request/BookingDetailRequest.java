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
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class BookingDetailRequest {
    String bookingId;
    String roomId;
    LocalDateTime checkInDate;
    LocalDateTime checkOutDate;
    int adult;
    int child;
    Promotion promotion;
    BookingStatus bookingStatusId;
}
