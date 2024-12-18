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
@Table(name = "Booking_Details")
public class BookingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Booking_Detail_ID")
    String bookingDetailId;

    @ManyToOne
    @JoinColumn(name = "Booking_ID", referencedColumnName = "Booking_ID")
    Booking booking;

    @OneToOne
    @JoinColumn(name="Room_ID", referencedColumnName = "Room_ID")
    Room roomId;

    @Column(name = "Check_In_Date")
    Date checkInDate;

    @Column(name = "Check_Out_Date")
    Date checkOutDate;

    @Column(name = "Adult")
    int adult;

    @Column(name = "Child")
    int child;

    @ManyToOne
    @JoinColumn(name = "Promotion_ID", referencedColumnName = "Promotion_ID")
    Promotion promotion;

    @ManyToOne
    @JoinColumn(name = "Booking_Status_ID", referencedColumnName = "Booking_Status_ID")
    BookingStatus bookingStatusId;
}
