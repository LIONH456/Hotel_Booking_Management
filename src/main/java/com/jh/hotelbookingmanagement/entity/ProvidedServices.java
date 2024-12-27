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
@Table(name = "Services")
public class ProvidedServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Service_ID")
    Long serviceId;

    @Column(name = "Service_Name")
    String serviceName;

    @Column(name = "Description")
    String description;

    @Column(name = "Price")
    double servicePrice;

    @Column(name = "Active")
    boolean serviceActive;
}
