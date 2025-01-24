package com.jh.hotelbookingmanagement.service.implement;

import com.jh.hotelbookingmanagement.dto.response.DashboardStatsResponse;
import com.jh.hotelbookingmanagement.dto.response.OccupancyStats;
import com.jh.hotelbookingmanagement.dto.response.RevenueStats;
import com.jh.hotelbookingmanagement.repository.BookingRepository;
import com.jh.hotelbookingmanagement.repository.RoomRepository;
import com.jh.hotelbookingmanagement.repository.UserRepository;
import com.jh.hotelbookingmanagement.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {
    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    @Override
    public DashboardStatsResponse getDashboardStats() {
        // Implement the logic to get overall dashboard stats
        return DashboardStatsResponse.builder()
                .totalBookings(bookingRepository.count())
                .activeBookings(bookingRepository.countActiveBookings())
                .totalRevenue(bookingRepository.calculateTotalRevenue())
                .occupancyRate(calculateCurrentOccupancyRate())
                .availableRooms(roomRepository.countAvailableRooms())
                .totalCustomers(userRepository.countCustomers())
                .build();
    }

    @Override
    public List<RevenueStats> getMonthlyRevenue() {
        // Implement the logic to get monthly revenue stats
        LocalDate startDate = LocalDate.now().minusMonths(12);
        return getMonthlyRevenueStats();
    }

    public List<RevenueStats> getMonthlyRevenueStats() {
        List<Object[]> monthlyRevenue = bookingRepository.getMonthlyRevenue();

        // Map the results to RevenueStats objects
        return monthlyRevenue.stream().map(result -> {
            int year = ((Number) result[0]).intValue(); // Extract year
            int month = ((Number) result[1]).intValue(); // Extract month
            double revenue = ((Number) result[2]).doubleValue(); // Extract revenue

            // Use the RevenueStats constructor
            return new RevenueStats(year, month, revenue);
        }).toList();
    }

    @Override
    public List<OccupancyStats> getDailyOccupancy() {
        // Implement the logic to get daily occupancy stats
        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime endDate = LocalDateTime.now().plusDays(1);
        return getDailyOccupancyStats(startDate, endDate);
    }

    public List<OccupancyStats> getDailyOccupancyStats(LocalDateTime startDate, LocalDateTime endDate) {
        List<Object[]> results = bookingRepository.getDailyOccupancy(startDate, endDate);

        // Map the query results to OccupancyStats
        return results.stream().map(result -> {
            LocalDate checkInDate = ((java.sql.Date) result[0]).toLocalDate();
            int totalRooms = ((Number) result[1]).intValue();
            int occupiedRooms = ((Number) result[2]).intValue();

            return new OccupancyStats(checkInDate, totalRooms, occupiedRooms);
        }).toList();
    }

    private double calculateCurrentOccupancyRate() {
        long totalRooms = roomRepository.count();
        long occupiedRooms = roomRepository.countOccupiedRooms(LocalDateTime.now());
        return totalRooms > 0 ? (double) occupiedRooms / totalRooms * 100 : 0;
    }
} 