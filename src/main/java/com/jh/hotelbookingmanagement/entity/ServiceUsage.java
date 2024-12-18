package com.jh.hotelbookingmanagement.entity;

import java.util.Date;

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
@Table(name = "Service_Usage")
public class ServiceUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Service_Usage_ID")
    String serviceUsageId;

    @Column(name = "Booking_ID")
    String bookingId;

    @ManyToOne
    @JoinColumn(name="Service_ID", referencedColumnName = "Service_ID")
    Services serviceId;

    @Column(name = "Date_Used")
    Date serviceUsedDate;

    @Column(name = "Quantity")
    int quantity;

    @Column(name = "Charge")
    double serviceCharge;
}
