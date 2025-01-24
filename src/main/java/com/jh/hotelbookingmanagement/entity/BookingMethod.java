package com.jh.hotelbookingmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking_methods")
public class BookingMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_method_id")
    private Long bookingMethodId;
    
    @Column(name = "booking_method", unique = true)
    private String bookingMethodName;
    
    private String description;
    private Boolean active;

    @OneToMany(mappedBy = "bookingMethod")
    private List<Booking> bookings;
}
