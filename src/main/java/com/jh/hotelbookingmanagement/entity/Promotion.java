package com.jh.hotelbookingmanagement.entity;

import java.util.Date;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "Promotion")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Promotion_ID")
    Integer promotionId;

    @Column(name = "Promotion_Name")
    String promotionName;

    @Column(name = "Start_Date")
    Date startDate;

    @Column(name = "End_Date")
    Date endDate;

    @Column(name = "Discount")
    double discount;

    @Column(name = "Description")
    String description;
}
