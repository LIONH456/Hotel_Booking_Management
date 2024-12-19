package com.jh.hotelbookingmanagement.dto.request;

import com.jh.hotelbookingmanagement.entity.BookingStatus;
import com.jh.hotelbookingmanagement.entity.Promotion;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class BookingDetailUpdateRequest {
    String roomId;
    Date checkInDate;
    Date checkOutDate;
    int adult;
    int child;
    Promotion promotion;
    BookingStatus bookingStatusId;
}
