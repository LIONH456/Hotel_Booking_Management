package com.jh.hotelbookingmanagement.dto.response;

import com.jh.hotelbookingmanagement.entity.BookingStatus;
import com.jh.hotelbookingmanagement.entity.Promotion;
import com.jh.hotelbookingmanagement.entity.Room;
import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class BookingDetailResponse {
    String bookingDetailId;
    String bookingId; // Only include bookingId as a String
    String branchId;
    String roomNumber;
    Date checkInDate;
    Date checkOutDate;
    int adult;
    int child;
    Promotion promotion;
    BookingStatus bookingStatusId;
    double roomCharge;
    double itemCharge;
    double serviceCharge;
    double totalAmount;
}
