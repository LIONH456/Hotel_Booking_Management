package com.jh.hotelbookingmanagement.repository;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jh.hotelbookingmanagement.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
    List<Room> findAllByBranch_BranchId(String branchId);
    @Query(value = "SELECT COUNT(*) FROM rooms r WHERE r.branchId.branchId = ?1", nativeQuery = true)
    int countRoomsByBranchId(@Param("branchId") String branchId);

    @Query(value = "SELECT COUNT(*) FROM rooms r WHERE r.room_status_id = '1'", nativeQuery = true)
    long countAvailableRooms();

//    @Query("SELECT r FROM Room r " +
//           "WHERE r.id NOT IN (" +
//           "    SELECT bd.room.id FROM BookingDetail bd " +
//           "    WHERE bd.booking.checkInDate <= :endDate " +
//           "    AND bd.booking.checkOutDate >= :startDate)")
//    List<Room> findAvailableRooms(LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT COUNT(r) FROM Room r")
    long countTotalRooms();

    @Query(value = "SELECT COUNT(DISTINCT bd.room_id) FROM booking_details bd JOIN bookings b ON b.booking_id = bd.booking_id WHERE bd.check_in_date <= :currentTime AND bd.Check_Out_Date >= :currentTime AND b.Active = true", nativeQuery = true)
    long countOccupiedRooms(LocalDateTime currentTime);
}
