package com.jh.hotelbookingmanagement.entity;

import jakarta.persistence.*;

import jakarta.persistence.criteria.CriteriaBuilder;
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
    Long itemId;

    @Column(name = "Item_Name", unique = true, nullable = false)
    String itemName;

    @Column(name = "Description")
    String description;

    @Column(name = "Price")
    double price;

    @Column(name = "Stock")
    int stock;

    @Column(name="Is_Served")
    boolean active;
}
