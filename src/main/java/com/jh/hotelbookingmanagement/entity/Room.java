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
@Table(name = "Rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String roomId;

    @Column(name = "Room_Number")
    String roomNumber;

    @ManyToOne
    @JoinColumn(name = "Room_Status_ID", referencedColumnName = "Room_Status_ID")
    RoomStatus roomStatusId;

    @ManyToOne
    @JoinColumn(name = "Room_Type_ID", referencedColumnName = "Room_Type_ID")
    RoomType roomTypeId;

    @Column(name = "Branch_ID")
    String branchId;

    @Column(name = "Descriptions")
    String description;

    @Column(name = "Price")
    double price;
}
