package com.jh.hotelbookingmanagement.entity;

import java.util.Date;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "Booking_Detail")
public class BookingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Booking_Detail_ID")
    String bookingDetailId;

    @Column(name = "Booking_ID")
    String bookingId;

    @Column(name = "Room_ID")
    String roomId;

    @Column(name = "Check_In_Date")
    Date checkInDate;

    @Column(name = "Check_Out_Date")
    Date checkOutDate;

    @Column(name = "Adult")
    int adult;

    @Column(name = "Child")
    int child;

    @Column(name = "Accepted_By")
    String acceptedBy;

    @Column(name = "Promotion_ID")
    int promotionId;
}
