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

    @ManyToOne
    @JoinColumn(name="Booking_ID", referencedColumnName = "Booking_ID")
    Booking booking;

    @OneToOne
    @JoinColumn(name = "Payment_Type_ID", referencedColumnName = "Payment_Type_ID")
    PaymentType paymentType;

    @Column(name = "Paid_Date")
    Date paidDate;

    @Column(name = "Service_Charges")
    double serviceCharges;

    @Column(name="Item_Charges")
    double itemCharges;

    @Column(name="Discount")
    double discount;

    @Column(name = "Amount")
    double amount;

    @Column(name = "Total_Paid")
    double totalPaid;

    @Column(name="Total")
    double total;
}
