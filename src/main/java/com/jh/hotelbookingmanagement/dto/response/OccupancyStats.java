package com.jh.hotelbookingmanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OccupancyStats {
    private LocalDate date;
    private int occupiedRooms;
    private int totalRooms;
    private double occupancyRate;

    // Constructor for native query mapping
    public OccupancyStats(java.sql.Date date, Long occupiedRooms, Long totalRooms, Double occupancyRate) {
        this.date = date.toLocalDate();
        this.occupiedRooms = occupiedRooms.intValue();
        this.totalRooms = totalRooms.intValue();
        this.occupancyRate = occupancyRate;
    }
} 