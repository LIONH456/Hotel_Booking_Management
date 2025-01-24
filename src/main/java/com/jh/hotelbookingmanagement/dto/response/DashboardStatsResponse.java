package com.jh.hotelbookingmanagement.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DashboardStatsResponse {
    private long totalBookings;
    private long activeBookings;
    private double totalRevenue;
    private double occupancyRate;
    private long availableRooms;
    private long totalCustomers;
} 