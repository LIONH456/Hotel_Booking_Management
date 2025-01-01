package com.jh.hotelbookingmanagement.dto.request;

import java.util.Date;

import com.jh.hotelbookingmanagement.entity.BookingMethod;
import com.jh.hotelbookingmanagement.entity.BookingStatus;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.mapstruct.Mapping;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingCreationRequest {
    Long bookingMethodId;
    Date bookedDate;
    int roomCount;
    String bookedBy;
}
