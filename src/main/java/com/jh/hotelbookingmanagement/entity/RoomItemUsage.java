package com.jh.hotelbookingmanagement.entity;

import jakarta.persistence.*;

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

    @Column(name = "Booking_ID")
    String bookingId;

    @ManyToOne
    @JoinColumn(name="Item_ID", referencedColumnName = "Item_ID")
    RoomItem itemId;

    @Column(name = "Quantity")
    int quantity;

    @Column(name = "Charge")
    double charge;
}
