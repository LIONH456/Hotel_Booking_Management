package com.jh.hotelbookingmanagement.service.implement;

import com.jh.hotelbookingmanagement.dto.response.DashboardStatsResponse;
import com.jh.hotelbookingmanagement.dto.response.OccupancyStats;
import com.jh.hotelbookingmanagement.dto.response.RevenueStats;
import com.jh.hotelbookingmanagement.repository.*;
import com.jh.hotelbookingmanagement.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final PaymentRepository paymentRepository;

    @Override
    public DashboardStatsResponse getDashboardStats() {
        long totalBookings = bookingRepository.count();
        long totalCustomers = userRepository.count();
        long totalRooms = roomRepository.count();
        double totalRevenue = paymentRepository.findTotalRevenue();
        long availableRooms = roomRepository.countAvailableRooms();
        double occupancyRate = ((double)(totalRooms - availableRooms) / totalRooms) * 100;

        return DashboardStatsResponse.builder()
                .totalBookings(totalBookings)
                .totalRevenue(totalRevenue)
                .totalCustomers(totalCustomers)
                .occupancyRate(occupancyRate)
                .availableRooms(availableRooms)
                .totalRooms(totalRooms)
                .build();
    }

    @Override
    public List<RevenueStats> getMonthlyRevenue() {
        LocalDate startDate = LocalDate.now().minusMonths(12);
        return paymentRepository.findMonthlyRevenue(startDate);
    }

    @Override
    public List<OccupancyStats> getDailyOccupancy() {
        LocalDate startDate = LocalDate.now().minusDays(30);
        return bookingRepository.findDailyOccupancy(startDate);
    }
} 