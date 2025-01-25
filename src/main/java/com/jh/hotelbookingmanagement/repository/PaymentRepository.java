package com.jh.hotelbookingmanagement.repository;

import com.jh.hotelbookingmanagement.entity.Payment;
import com.jh.hotelbookingmanagement.dto.response.RevenueStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
    @Query(value = "SELECT * FROM payments WHERE booking_id = :bookingId", nativeQuery = true)
    List<Payment> findByBookingBookingId(@Param("bookingId") String bookingId);

    @Query(value = "SELECT COALESCE(SUM(total), 0) FROM payments", nativeQuery = true)
    double findTotalRevenue();

    @Query(value = """
        SELECT DATE(paid_date) as date,
        SUM(total) as revenue,
        COUNT(*) as booking_count
        FROM payments
        WHERE paid_date >= :startDate
        GROUP BY DATE(paid_date)
        ORDER BY date
        """, nativeQuery = true)
    List<RevenueStats> findMonthlyRevenue(@Param("startDate") LocalDate startDate);
}
