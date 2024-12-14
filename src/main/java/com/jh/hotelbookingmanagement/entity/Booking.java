package com.jh.hotelbookingmanagement.entity;

import java.util.Date;

import jakarta.persistence.*;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "Bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Booking_ID")
    String bookingId;

    @ManyToOne
    @JoinColumn(name = "Booking_Status_ID", referencedColumnName = "Booking_Status_ID")
    BookingStatus bookingStatusId;

    @ManyToOne
    @JoinColumn(name = "Booking_Method_ID", referencedColumnName = "Booking_Method_ID")
    BookingMethod bookingMethodId;

    @Column(name = "Booked_Date")
    Date bookedDate;

    @Column(name = "Room_Count")
    int roomCount;

    @Column(name = "Booked_By")
    String bookedBy;
}
