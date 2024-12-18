package com.jh.hotelbookingmanagement.entity;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

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
    @Column(name="Room_ID")
    String roomId;

    @Column(name = "Room_Number", nullable = false)
    String roomNumber;

    @ManyToOne
    @JoinColumn(name = "Room_Status_ID", referencedColumnName = "Room_Status_ID", nullable = true)
    RoomStatus roomStatusId;

    @ManyToOne
    @JoinColumn(name = "Room_Type_ID", referencedColumnName = "Room_Type_ID", nullable = true)
    RoomType roomTypeId;

    @ManyToOne
    @JoinColumn(name="Branch_ID", referencedColumnName = "Branch_ID")
    Branch branch;

    @Column(name = "Descriptions")
    String description;

    @Column(name = "Price", nullable = false)
    double price;

    @ManyToMany
    @JoinTable(
            name = "room_picture", // Name of the join table
            joinColumns = @JoinColumn(name = "Room_ID"), // Foreign key in join table referencing Picture
            inverseJoinColumns = @JoinColumn(name = "Picture_ID") // Foreign key in join table referencing Room
    )
    List<Picture> pictures;
}
