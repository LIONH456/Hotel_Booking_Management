package com.jh.hotelbookingmanagement.entity;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "Booking_Status")
public class BookingStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Booking_Status_ID")
    Long bookingStatusId;

    @Column(name = "Booking_Status", unique = true)
    String bookingStatusName;

    @Column(name = "Description")
    String description;
}
