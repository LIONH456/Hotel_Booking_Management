package com.jh.hotelbookingmanagement.entity;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "booking_details")
public class BookingDetail {
    @Id
    @Column(name = "booking_detail_id")
    private String bookingDetailId;
    
    private Integer adult;
    private Integer child;
    
    @Column(name = "check_in_date")
    private LocalDateTime checkInDate;
    
    @Column(name = "check_out_date")
    private LocalDateTime checkOutDate;
    
    @Column(name = "item_charge")
    private Double itemCharge;
    
    @Column(name = "total_room_charge")
    private Double totalRoomCharge;
    
    @Column(name = "service_charge")
    private Double serviceCharge;
    
    @Column(name = "total_amount")
    private Double totalAmount;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    @JsonBackReference
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_status_id", referencedColumnName = "booking_status_id")
    private BookingStatus bookingStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    private Room room;
}
