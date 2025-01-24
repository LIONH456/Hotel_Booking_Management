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
    List<Payment> findByBookingBookingId(String bookingId);

    @Query("SELECT COALESCE(SUM(p.total), 0) FROM Payment p")
    double findTotalRevenue();

    @Query("SELECT new com.jh.hotelbookingmanagement.dto.response.RevenueStats(" +
            "CAST(p.paidDate AS date) as date, " +
            "SUM(p.total) as revenue, " +
            "COUNT(p) as bookingCount) " +
            "FROM Payment p " +
            "WHERE p.paidDate >= :startDate " +
            "GROUP BY CAST(p.paidDate AS date) " +
            "ORDER BY date")
    List<RevenueStats> findMonthlyRevenue(@Param("startDate") LocalDate startDate);
}
