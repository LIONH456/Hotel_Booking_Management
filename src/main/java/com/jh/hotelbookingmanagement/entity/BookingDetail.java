package com.jh.hotelbookingmanagement.entity;

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
@Table(name = "Booking_Details")
public class BookingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Booking_Detail_ID")
    String bookingDetailId;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    @JsonBackReference
    private Booking booking;

    @ManyToOne
    @JoinColumn(name="Room_ID", referencedColumnName = "Room_ID")
    Room room;

    @Column(name = "Check_In_Date")
    Date checkInDate;

    @Column(name = "Check_Out_Date")
    Date checkOutDate;

    @Column(name = "Adult")
    int adult;

    @Column(name = "Child")
    int child;

    @ManyToOne
    @JoinColumn(name = "Booking_Status_ID", referencedColumnName = "Booking_Status_ID")
    BookingStatus bookingStatusId;

    @Column(name="Total_Room_Charge")
    double roomCharge;

    @Column(name= "Item_Charge")
    double itemCharge;

    @Column(name="Service_Charge")
    double serviceCharge;

    @Column(name="Total_Amount")
    double totalAmount;
}
