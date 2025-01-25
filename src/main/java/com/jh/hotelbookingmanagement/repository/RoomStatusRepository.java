package com.jh.hotelbookingmanagement.repository;

import com.jh.hotelbookingmanagement.entity.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomStatusRepository extends JpaRepository<RoomStatus, Integer> {
}