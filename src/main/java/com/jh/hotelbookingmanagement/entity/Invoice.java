package com.jh.hotelbookingmanagement.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Invoice")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Invoice_ID")
    String invoiceId;

    @ManyToOne
    @JoinColumn(name = "Booking_ID", referencedColumnName = "Booking_ID")
    Booking booking;

//    @OneToMany
//    @JoinColumn(name="Booking_Detail_ID", referencedColumnName = "Booking_Detail_ID")
//    List<BookingDetail> bookingDetail;

    @Column(name = "Invoice_Date")
    Date invoiceDate;

    @Column(name = "Total_Amount")
    double totalAmount;

//    @ManyToOne
//    @JoinColumn(name = "Promotion_ID", referencedColumnName = "Promotion_ID")
//    Promotion promotion;

    @Column(name="promotion_In_Percentage")
    double promotionInPercentage;

    @Column(name="Discounted_Amount")
    double discountedAmount;

    @Column(name = "Tax")
    double tax;

    @Column(name = "Final_Amount")
    double finalAmount;
}

