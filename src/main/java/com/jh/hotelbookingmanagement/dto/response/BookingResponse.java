package com.jh.hotelbookingmanagement.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

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
    LocalDateTime bookedDate;
    Integer roomCount;
    BigDecimal totalAmount;
    String bookingMethodName;
    String bookedByUsername;
    Set<BookingDetailResponse> bookingDetails;
}

