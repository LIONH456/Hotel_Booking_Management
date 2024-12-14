package com.jh.hotelbookingmanagement.dto.response;

import java.util.Date;

import jakarta.persistence.*;

import com.jh.hotelbookingmanagement.entity.BookingMethod;
import com.jh.hotelbookingmanagement.entity.BookingStatus;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class BookingResponse {
    String bookingId;
    BookingStatus bookingStatusId;
    BookingMethod bookingMethodId;
    Date bookedDate;
    int roomCount;
    String bookedBy;
}
