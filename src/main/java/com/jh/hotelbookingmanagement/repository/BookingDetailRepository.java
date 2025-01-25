package com.jh.hotelbookingmanagement.repository;

import com.jh.hotelbookingmanagement.entity.Booking;
import com.jh.hotelbookingmanagement.entity.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingDetailRepository extends JpaRepository<BookingDetail, String> {
    @Query(value = """
        SELECT bd.* FROM booking_details bd 
        WHERE bd.room_id = :roomId 
        AND bd.booking_status_id != 4  -- Assuming 4 is cancelled status
        AND (
            (:checkIn BETWEEN bd.check_in_date AND bd.check_out_date)
            OR 
            (:checkOut BETWEEN bd.check_in_date AND bd.check_out_date)
            OR 
            (bd.check_in_date BETWEEN :checkIn AND :checkOut)
        )
        """, nativeQuery = true)
    List<BookingDetail> findConflictingBookings(
        @Param("roomId") String roomId,
        @Param("checkIn") LocalDateTime checkIn,
        @Param("checkOut") LocalDateTime checkOut
    );

    @Query(value = """
        UPDATE bookings b 
        SET b.room_count = (
            SELECT COUNT(*) 
            FROM booking_details bd 
            WHERE bd.booking_id = :bookingId
        ) 
        WHERE b.booking_id = :bookingId
        """, nativeQuery = true)
    @Modifying
    void updateRoomCount(@Param("bookingId") String bookingId);

    List<BookingDetail> findAllByBooking_BookingId(String bookingId);
}
