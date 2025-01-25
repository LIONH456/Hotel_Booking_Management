package com.jh.hotelbookingmanagement.repository;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jh.hotelbookingmanagement.entity.Room;
import com.jh.hotelbookingmanagement.dto.response.OccupancyStats;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
    @Query(value = "SELECT * FROM rooms WHERE branch_id = :branchId", nativeQuery = true)
    List<Room> findAllByBranch_BranchId(@Param("branchId") String branchId);

    @Query(value = "SELECT COUNT(*) FROM rooms WHERE branch_id = :branchId", nativeQuery = true)
    int countRoomsByBranchId(@Param("branchId") String branchId);

    @Query(value = "SELECT COUNT(*) FROM rooms WHERE room_status_id = 1", nativeQuery = true)
    long countAvailableRooms();

    @Query(value = "SELECT COUNT(*) FROM rooms", nativeQuery = true)
    long countTotalRooms();

    @Query(value = """
        SELECT COUNT(DISTINCT bd.room_id) 
        FROM booking_details bd 
        JOIN bookings b ON b.booking_id = bd.booking_id 
        WHERE bd.check_in_date <= :currentTime 
        AND bd.check_out_date >= :currentTime 
        AND b.active = true
        """, nativeQuery = true)
    long countOccupiedRooms(@Param("currentTime") LocalDateTime currentTime);

    @Query(value = """
        SELECT 
            DATE(bd.check_in_date) as date,
            COUNT(DISTINCT bd.room_id) as occupied_rooms,
            (SELECT COUNT(*) FROM rooms) as total_rooms,
            (COUNT(DISTINCT bd.room_id) * 100.0 / (SELECT COUNT(*) FROM rooms)) as occupancy_rate
        FROM booking_details bd
        WHERE bd.check_in_date >= :startDate
        GROUP BY DATE(bd.check_in_date)
        ORDER BY date
        """, nativeQuery = true)
    List<OccupancyStats> getDailyOccupancy(@Param("startDate") LocalDateTime startDate);

    @Query(value = """
        SELECT rs.room_status as status, COUNT(r.room_id) as count
        FROM rooms r
        JOIN room_status rs ON r.room_status_id = rs.room_status_id
        GROUP BY rs.room_status
        """, nativeQuery = true)
    List<Object[]> getRoomStatusDistribution();
}
