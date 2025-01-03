package com.jh.hotelbookingmanagement.repository;

import com.jh.hotelbookingmanagement.entity.Booking;
import com.jh.hotelbookingmanagement.entity.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingDetailRepository extends JpaRepository<BookingDetail, String> {
    @Modifying
    @Query(value = "UPDATE bookings SET room_count = (SELECT Count(*) from booking_details) WHERE booking_id = :bookingId", nativeQuery = true)
    void updateRoomCount(@Param("bookingId") String bookingId);

    List<BookingDetail> findAllByBooking_BookingId(String bookingId);
}
