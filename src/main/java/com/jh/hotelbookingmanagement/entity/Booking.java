package com.jh.hotelbookingmanagement.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.Builder;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "bookings")
public class Booking {
    @Id
    @Column(name = "booking_id")
    private String bookingId;
    
    @Column(name = "booked_date")
    private LocalDateTime bookedDate;
    
    @Column(name = "room_count")
    private Integer roomCount;
    
    @Column(name = "total_amount")
    private Double totalAmount;
    
    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booked_by", referencedColumnName = "user_id")
    private User bookedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_method_id", referencedColumnName = "booking_method_id")
    private BookingMethod bookingMethod;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<BookingDetail> bookingDetails;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Payment> payments;
}
