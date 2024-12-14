package com.jh.hotelbookingmanagement.dto.request;

import java.util.Date;

import com.jh.hotelbookingmanagement.entity.BookingMethod;
import com.jh.hotelbookingmanagement.entity.BookingStatus;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingCreationRequest {
    BookingStatus bookingStatusId;
    BookingMethod bookingMethodId;
    Date bookedDate;
    int roomCount;
    String bookedBy;
}
