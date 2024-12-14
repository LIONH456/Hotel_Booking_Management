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
@Table(name = "Rooms_Type")
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Room_Type_ID")
    int roomTypeId;

    @Column(name = "Room_Type")
    String roomTypeName;

    @Column(name = "Description")
    String description;

    @Column(name = "Occupancy")
    String occupancy;

    @Column(name = "Bed_Count")
    int bedCount;

    @Column(name = "Active")
    boolean active;
}
