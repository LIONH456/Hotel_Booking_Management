package com.jh.hotelbookingmanagement.repository;

import com.jh.hotelbookingmanagement.entity.BookingMethod;
import com.jh.hotelbookingmanagement.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
}
