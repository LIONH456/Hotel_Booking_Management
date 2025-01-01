package com.jh.hotelbookingmanagement.entity;

import java.util.Date;
import java.util.List;

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
    @JoinColumn(name = "Booking_Method_ID", referencedColumnName = "Booking_Method_ID")
    BookingMethod bookingMethod;

    @Column(name = "Booked_Date")
    Date bookedDate;

    @Column(name = "Room_Count")
    int roomCount;

    @ManyToOne
    @JoinColumn(name = "Booked_By", referencedColumnName = "User_ID")
    User bookedBy;

    @Column(name = "Active")
    boolean active;
}
