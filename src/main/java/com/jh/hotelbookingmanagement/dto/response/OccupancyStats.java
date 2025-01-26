package com.jh.hotelbookingmanagement.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OccupancyStats {
    LocalDate date;
    Integer occupiedRooms;
    Integer totalRooms;
    Double occupancyRate;

    // Constructor for native query results
    public OccupancyStats(Object[] values) {
        this.date = values[0] != null ? ((java.sql.Date) values[0]).toLocalDate() : null;
        this.occupiedRooms = values[1] != null ? ((Number) values[1]).intValue() : 0;
        this.totalRooms = values[2] != null ? ((Number) values[2]).intValue() : 0;
        this.occupancyRate = values[3] != null ? ((Number) values[3]).doubleValue() : 0.0;
    }
} 