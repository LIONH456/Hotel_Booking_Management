package com.jh.hotelbookingmanagement.repository;

import com.jh.hotelbookingmanagement.entity.Rate;
import com.jh.hotelbookingmanagement.entity.RoomItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {
}
