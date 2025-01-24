package com.jh.hotelbookingmanagement.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DashboardStatsResponse {
    private long totalBookings;
    private double totalRevenue;
    private long totalCustomers;
    private double occupancyRate;
    private long availableRooms;
    private long totalRooms;
} 