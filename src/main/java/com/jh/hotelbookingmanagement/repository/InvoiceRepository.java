package com.jh.hotelbookingmanagement.repository;

import com.jh.hotelbookingmanagement.entity.Invoice;
import com.jh.hotelbookingmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, String> {
    @Query(value="SELECT sum(total_amount) FROM booking_details WHERE booking_id = :bookingId", nativeQuery = true)
    double getTotalAmount(@Param("bookingId") String bookingId);
}
