package com.jh.hotelbookingmanagement.repository;

import com.jh.hotelbookingmanagement.entity.RoomItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomItemRepository extends JpaRepository<RoomItem, Long> {
}
