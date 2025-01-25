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

    @Query(value = "SELECT booking_detail_id FROM booking_details WHERE booking_id = ?1", nativeQuery = true)
    List<String> isActive(String bookingId);

    @Query(value = "SELECT COUNT(*) FROM bookings WHERE active = 1", nativeQuery = true)
    long countActiveBookings();

    @Query(value = "SELECT SUM(total_amount) FROM bookings", nativeQuery = true)
    Double calculateTotalRevenue();

    // Daily occupancy stats
    @Query(value = """
        SELECT DATE(bd.check_in_date) as date,
        COUNT(DISTINCT bd.room_id) as occupied_rooms,
        (SELECT COUNT(*) FROM rooms) as total_rooms,
        (COUNT(DISTINCT bd.room_id) * 100.0 / (SELECT COUNT(*) FROM rooms)) as occupancy_rate
        FROM booking_details bd
        WHERE bd.check_in_date >= :startDate
        GROUP BY DATE(bd.check_in_date)
        ORDER BY date
        """, nativeQuery = true)
    List<Object[]> getDailyOccupancy(@Param("startDate") LocalDateTime startDate);

    // Monthly revenue by year
    @Query(value = """
        SELECT MONTH(b.booked_date) as month, 
        COUNT(*) as booking_count,
        SUM(b.total_amount) as revenue
        FROM bookings b
        WHERE YEAR(b.booked_date) = :year
        GROUP BY MONTH(b.booked_date)
        """, nativeQuery = true)
    List<Object[]> getYearlyRevenue(@Param("year") int year);

    // Booking methods distribution
    @Query(value = """
        SELECT bm.booking_method, COUNT(b.booking_id)
        FROM bookings b
        JOIN booking_methods bm ON b.booking_method_id = bm.booking_method_id
        GROUP BY bm.booking_method
        """, nativeQuery = true)
    List<Object[]> getBookingsByType();

    @Query(value = "SELECT SUM(total_amount) FROM bookings WHERE booked_date >= :startDate", nativeQuery = true)
    Double calculateRevenueForPeriod(@Param("startDate") LocalDateTime startDate);

    @Query(value = "SELECT COUNT(*) FROM bookings WHERE booked_date >= :startDate", nativeQuery = true)
    Long countBookingsForPeriod(@Param("startDate") LocalDateTime startDate);

    // Monthly revenue stats
    @Query(value = """
        SELECT 
        YEAR(b.booked_date) as year,
        MONTH(b.booked_date) as month,
        COUNT(*) as booking_count,
        SUM(b.total_amount) as total_revenue
        FROM bookings b
        GROUP BY YEAR(b.booked_date), MONTH(b.booked_date)
        ORDER BY year, month
        """, nativeQuery = true)
    List<Object[]> getMonthlyRevenueStats();

    // Booking method distribution
    @Query(value = """
        SELECT bm.booking_method, COUNT(b.booking_id)
        FROM bookings b
        JOIN booking_methods bm ON b.booking_method_id = bm.booking_method_id
        GROUP BY bm.booking_method
        """, nativeQuery = true)
    List<Object[]> getBookingsByMethod();

    // Room type distribution
    @Query(value = """
        SELECT rt.room_type, COUNT(bd.booking_detail_id)
        FROM booking_details bd
        JOIN rooms r ON bd.room_id = r.room_id
        JOIN rooms_type rt ON r.room_type_id = rt.room_type_id
        GROUP BY rt.room_type
        """, nativeQuery = true)
    List<Object[]> getRoomTypeDistribution();

    @Query(value = """
        SELECT MONTH(b.booked_date) as month, SUM(i.total_amount) as revenue 
        FROM bookings b
        JOIN invoice i ON b.booking_id = i.booking_id
        WHERE YEAR(b.booked_date) = YEAR(CURRENT_DATE)
        AND MONTH(b.booked_date) = :month
        GROUP BY MONTH(b.booked_date)
        """, nativeQuery = true)
    List<RevenueStats> getMonthlyRevenue(@Param("month") int month);

    // Find latest 10 bookings
    @Query(value = """
        SELECT * FROM bookings 
        ORDER BY booked_date DESC 
        LIMIT 10
        """, nativeQuery = true)
    List<Booking> findLatestBookings();
}
