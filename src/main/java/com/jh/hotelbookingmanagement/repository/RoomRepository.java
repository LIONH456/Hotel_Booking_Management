package com.jh.hotelbookingmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jh.hotelbookingmanagement.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
    List<Room> findAllByBranchId(String branchId);
}
