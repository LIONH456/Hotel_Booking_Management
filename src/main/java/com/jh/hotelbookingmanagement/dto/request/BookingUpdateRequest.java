package com.jh.hotelbookingmanagement.dto.request;

import com.jh.hotelbookingmanagement.entity.BookingStatus;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingUpdateRequest {
    BookingStatus bookingStatusId;
    int roomCount;
}
