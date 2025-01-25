package com.jh.hotelbookingmanagement.repository;

import com.jh.hotelbookingmanagement.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, String> {
    boolean existsByRoomTypeName(String roomTypeName);
} 