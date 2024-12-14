package com.jh.hotelbookingmanagement.entity;

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
@Table(name = "Room_Item")
public class RoomItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Item_ID")
    int itemId;

    @Column(name = "Item_Name")
    String itemName;

    @Column(name = "Description")
    String description;

    @Column(name = "Price")
    double price;

    @Column(name = "Stock")
    int stock;

    @Column(name = "Room_ID")
    String roomId;
}
