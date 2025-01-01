package com.jh.hotelbookingmanagement.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "Room_Item_Usage")
public class RoomItemUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Item_Usage_ID")
    String itemUsageId;

    @ManyToOne
    @JoinColumn(name = "Booking_Detail_ID", referencedColumnName = "Booking_Detail_ID", nullable = false)
    BookingDetail bookingDetail;

    @ManyToOne
    @JoinColumn(name="Item_ID", referencedColumnName = "Item_ID", nullable = false)
    RoomItem item;

    @Column(name = "Quantity")
    int quantity;

    @Column(name = "Charge")
    double charge;

    @Column(name="Room_ID")
    String roomId;
}
