package com.jh.hotelbookingmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jh.hotelbookingmanagement.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
    List<Room> findAllByBranch_BranchId(String branchId);
    @Query(value = "SELECT COUNT(*) FROM Room r WHERE r.branchId.branchId = ?1", nativeQuery = true)
    int countRoomsByBranchId(@Param("branchId") String branchId);

}
