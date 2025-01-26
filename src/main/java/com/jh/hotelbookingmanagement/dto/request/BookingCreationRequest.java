package com.jh.hotelbookingmanagement.dto.request;

import java.util.Date;
import java.util.List;

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
    String bookedBy;  // userId
    List<BookingDetailRequest> bookingDetails;  // Include booking details directly
}
