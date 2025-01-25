package com.jh.hotelbookingmanagement.controller;

import com.jh.hotelbookingmanagement.dto.request.ApiResponse;
import com.jh.hotelbookingmanagement.dto.response.*;
import com.jh.hotelbookingmanagement.service.DashboardService;
import com.jh.hotelbookingmanagement.service.implement.DashboardServiceImplement;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DashboardController {
    DashboardServiceImplement dashboardService;

    @GetMapping("/stats")
    public ApiResponse<?> getDashboardStats() {
        return ApiResponse.builder()
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

    @GetMapping("/recent-bookings")
    public ApiResponse<?> getRecentBookings() {
        return ApiResponse.builder()
                .result(dashboardService.getRecentBookings())
                .build();
    }

    @GetMapping("/recent-customers")
    public ApiResponse<?> getRecentCustomers() {
        return ApiResponse.builder()
                .result(dashboardService.getRecentCustomers())
                .build();
    }

    @GetMapping("/package-stats")
    public ApiResponse<?> getPackageStats() {
        return ApiResponse.builder()
                .result(dashboardService.getPackageStats())
                .build();
    }

    @GetMapping("/room-distribution")
    public ApiResponse<?> getRoomDistribution() {
        return ApiResponse.builder()
                .result(dashboardService.getRoomDistribution())
                .build();
    }

    @GetMapping("/booking-trends")
    public ApiResponse<BookingTrendsResponse> getBookingTrends() {
        return ApiResponse.<BookingTrendsResponse>builder()
                .result(dashboardService.getBookingTrends())
                .build();
    }
} 