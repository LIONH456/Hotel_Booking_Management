package com.jh.hotelbookingmanagement.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class OccupancyStats {
    private LocalDate date;
    private int totalRooms;
    private int occupiedRooms;
    private double occupancyRate;

    public OccupancyStats(LocalDate date, int totalRooms, int occupiedRooms) {
        this.date = date;
        this.totalRooms = totalRooms;
        this.occupiedRooms = occupiedRooms;
    }
} 