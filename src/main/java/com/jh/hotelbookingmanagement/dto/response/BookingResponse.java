package com.jh.hotelbookingmanagement.dto.response;

import java.util.Date;
import java.util.List;

import com.jh.hotelbookingmanagement.entity.BookingDetail;
import com.jh.hotelbookingmanagement.entity.User;
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
    BookingMethod bookingMethodId;
    Date bookedDate;
    int roomCount;
    User bookedBy;
    List<BookingDetail> bookingDetails;
    boolean active;
}
