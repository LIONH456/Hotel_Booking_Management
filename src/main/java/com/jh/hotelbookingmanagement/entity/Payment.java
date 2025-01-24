package com.jh.hotelbookingmanagement.entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "payments")
@Builder
public class Payment {
    @Id
    @Column(name = "payment_id")
    private String paymentId;
    
    private Double amount;
    private Double discount;
    
    @Column(name = "item_charges")
    private Double itemCharges;
    
    @Column(name = "service_charges")
    private Double serviceCharges;
    
    private Double total;
    
    @Column(name = "total_paid")
    private Double totalPaid;
    
    @Column(name = "paid_date")
    private LocalDateTime paidDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", referencedColumnName = "booking_id")
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_type_id", referencedColumnName = "payment_type_id")
    private PaymentType paymentType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_status_id", referencedColumnName = "payment_status_id")
    private PaymentStatus paymentStatus;
}
