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
@Table(name = "Seasonal_Pricing")
public class SeasonalPricing {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Seasonal_Pricing_ID")
    String seasonalPriceId;

    @Column(name = "Room_Type_Id")
    int roomTypeId;

    @Column(name = "Season_Name")
    String seasonName;

    @Column(name = "Start_Date")
    Date startDate;

    @Column(name = "End_Date")
    Date endDate;

    @Column(name = "Seasonal_Rate")
    double seasonalRate;
}
