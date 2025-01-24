package com.jh.hotelbookingmanagement.repository;

import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jh.hotelbookingmanagement.entity.Booking;
import com.jh.hotelbookingmanagement.dto.response.RevenueStats;
import com.jh.hotelbookingmanagement.dto.response.OccupancyStats;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {
    List<Booking> findByBookedByUserId(String userId);

    // value: Specifies the actual query string.
    // nativeQuery = true: Indicates this is a native SQL query (not a JPA Query Language - JPQL).
    @Query(value = "SELECT booking_detail_id from booking_details Where Booking_ID =?1", nativeQuery = true)
    List<String> isActive(String bookingId);

    // Count active bookings
    @Query(value = "SELECT COUNT(*) FROM bookings b WHERE b.active = '1'", nativeQuery = true)
    long countActiveBookings();

    // Calculate total revenue
    @Query(value = "SELECT SUM(b.total_amount) FROM bookings b", nativeQuery = true)
    Double calculateTotalRevenue();

    // Get monthly revenue stats
    @Query(value = "SELECT " +
            "YEAR(b.booked_date) as year, " +
            "MONTH(b.booked_date) as month, " +
            "COALESCE(SUM(bd.total_amount), 0) as revenue " +
            "FROM bookings b " +
            "LEFT JOIN booking_details bd ON b.booking_id = bd.booking_id " +
            "GROUP BY YEAR(b.booked_date), MONTH(b.booked_date) " +
            "ORDER BY year DESC, month DESC",
            nativeQuery = true)
    List<Object[]> getMonthlyRevenue();

    // Get daily occupancy stats
    @Query("SELECT new com.jh.hotelbookingmanagement.dto.response.OccupancyStats(" +
            "CAST(bd.checkInDate AS date) as date, " +
            "COUNT(DISTINCT bd.room) as occupiedRooms, " +
            "(SELECT COUNT(r) FROM Room r) as totalRooms, " +
            "CAST(COUNT(DISTINCT bd.room) AS double) / CAST((SELECT COUNT(r) FROM Room r) AS double) * 100 as occupancyRate) " +
            "FROM BookingDetail bd " +
            "WHERE bd.checkInDate >= :startDate " +
            "GROUP BY CAST(bd.checkInDate AS date) " +
            "ORDER BY date")
    List<OccupancyStats> findDailyOccupancy(@Param("startDate") LocalDate startDate);

}
