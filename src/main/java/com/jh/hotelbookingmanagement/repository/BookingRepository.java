package com.jh.hotelbookingmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jh.hotelbookingmanagement.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {
    List<Booking> findByBookedByUserId(String userId);

    // value: Specifies the actual query string.
    // nativeQuery = true: Indicates this is a native SQL query (not a JPA Query Language - JPQL).
    @Query(value = "SELECT booking_detail_id from booking_details Where Booking_ID =?1", nativeQuery = true)
    List<String> isActive(String bookingId);
}
