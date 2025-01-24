package com.jh.hotelbookingmanagement.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class OccupancyStats {
    private LocalDate date;
    private int occupiedRooms;
    private int totalRooms;
    private double occupancyRate;
} 