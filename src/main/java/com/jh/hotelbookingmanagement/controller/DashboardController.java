package com.jh.hotelbookingmanagement.controller;

import com.jh.hotelbookingmanagement.dto.request.ApiResponse;
import com.jh.hotelbookingmanagement.dto.response.DashboardStatsResponse;
import com.jh.hotelbookingmanagement.dto.response.OccupancyStats;
import com.jh.hotelbookingmanagement.dto.response.RevenueStats;
import com.jh.hotelbookingmanagement.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    private final DashboardService dashboardService;

    @GetMapping("/stats")
    public ApiResponse<DashboardStatsResponse> getStats() {
        return ApiResponse.<DashboardStatsResponse>builder()
                .result(dashboardService.getDashboardStats())
                .build();
    }

    @GetMapping("/revenue/monthly")
    public ApiResponse<List<RevenueStats>> getMonthlyRevenue() {
        return ApiResponse.<List<RevenueStats>>builder()
                .result(dashboardService.getMonthlyRevenue())
                .build();
    }

    @GetMapping("/occupancy/daily")
    public ApiResponse<List<OccupancyStats>> getDailyOccupancy() {
        return ApiResponse.<List<OccupancyStats>>builder()
                .result(dashboardService.getDailyOccupancy())
                .build();
    }
} 