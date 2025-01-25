package com.jh.hotelbookingmanagement.service.implement;

import com.jh.hotelbookingmanagement.dto.response.BookingResponse;
import com.jh.hotelbookingmanagement.dto.response.DashboardStatsResponse;
import com.jh.hotelbookingmanagement.dto.response.RevenueStats;
import com.jh.hotelbookingmanagement.dto.response.OccupancyStats;
import com.jh.hotelbookingmanagement.dto.response.UserResponse;
import com.jh.hotelbookingmanagement.dto.response.BookingTrendsResponse;
import com.jh.hotelbookingmanagement.mapper.BookingMapper;
import com.jh.hotelbookingmanagement.repository.BookingRepository;
import com.jh.hotelbookingmanagement.repository.RoomRepository;
import com.jh.hotelbookingmanagement.repository.UserRepository;
import com.jh.hotelbookingmanagement.mapper.UserMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DashboardServiceImplement {
    BookingRepository bookingRepository;
    RoomRepository roomRepository;
    UserRepository userRepository;
    BookingMapper bookingMapper;
    UserMapper userMapper;

    public DashboardStatsResponse getDashboardStats() {
        LocalDateTime startOfDay = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        
        return DashboardStatsResponse.builder()
                .totalRooms(roomRepository.countTotalRooms())
                .occupiedRooms(roomRepository.countOccupiedRooms(LocalDateTime.now()))
                .todayRevenue(bookingRepository.calculateRevenueForPeriod(startOfDay))
                .todayBookings(bookingRepository.countBookingsForPeriod(startOfDay))
                .build();
    }

    public List<RevenueStats> getMonthlyRevenue() {
        return bookingRepository.getMonthlyRevenue(1);
    }

    public List<OccupancyStats> getDailyOccupancy() {
        LocalDateTime startDate = LocalDateTime.now().minusDays(30);
        return roomRepository.getDailyOccupancy(startDate);
    }

    public List<BookingResponse> getRecentBookings() {
        return bookingRepository.findRecentBookings(PageRequest.of(0, 10))
                .stream()
                .map(bookingMapper::toBookingResponse)
                .collect(Collectors.toList());
    }

    public List<UserResponse> getRecentCustomers() {
        return userRepository.findRecentCustomers(PageRequest.of(0, 10))
                .stream().map(userMapper::toUserResponse)
                .collect(Collectors.toList());
    }

    public Map<String, Long> getPackageStats() {
        return bookingRepository.getRoomTypeDistribution()
                .stream()
                .collect(Collectors.toMap(
                    arr -> (String) arr[0],
                    arr -> (Long) arr[1]
                ));
    }

    public Map<String, Long> getRoomDistribution() {
        return roomRepository.getRoomStatusDistribution()
                .stream()
                .collect(Collectors.toMap(
                    arr -> (String) arr[0],
                    arr -> (Long) arr[1]
                ));
    }

    public BookingTrendsResponse getBookingTrends() {
        Map<String, Long> bookingsByMethod = bookingRepository.getBookingsByMethod()
                .stream()
                .collect(Collectors.toMap(
                    arr -> (String) arr[0],
                    arr -> (Long) arr[1]
                ));

        return BookingTrendsResponse.builder()
                .bookingsByMethod(bookingsByMethod)
                .build();
    }
} 