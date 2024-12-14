package com.jh.hotelbookingmanagement.entity;

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
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Payment_ID")
    String paymentId;

    @Column(name = "Booking_ID")
    String bookingId;

    @OneToOne
    @JoinColumn(name = "Payment_Type_ID", referencedColumnName = "Payment_Type_ID")
    PaymentType paymentType;

    @Column(name = "Amount")
    double amount;

    @Column(name = "Paid_Date")
    Date paidDate;

    @Column(name = "Paid_By")
    String paidBy;

    @Column(name = "Service_Charge")
    double serviceCharge;

    @Column(name = "Total_Paid")
    double totalPaid;
}
