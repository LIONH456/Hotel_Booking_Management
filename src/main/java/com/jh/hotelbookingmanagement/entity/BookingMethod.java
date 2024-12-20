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
@Table(name = "Booking_Methods")
public class BookingMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Booking_Method_ID")
    Long bookingMethodId;

    @Column(name = "Booking_Method", unique = true)
    String bookingMethodName;

    @Column(name = "Description")
    String description;

    @Column(name = "Active")
    boolean active;
}
