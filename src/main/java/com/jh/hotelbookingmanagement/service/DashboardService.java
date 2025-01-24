package com.jh.hotelbookingmanagement.service;

import com.jh.hotelbookingmanagement.dto.response.DashboardStatsResponse;
import com.jh.hotelbookingmanagement.dto.response.OccupancyStats;
import com.jh.hotelbookingmanagement.dto.response.RevenueStats;

import java.util.List;

public interface DashboardService {
    DashboardStatsResponse getDashboardStats();
    List<RevenueStats> getMonthlyRevenue();
    List<OccupancyStats> getDailyOccupancy();
} 