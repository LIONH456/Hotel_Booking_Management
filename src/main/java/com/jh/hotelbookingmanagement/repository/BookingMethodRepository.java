package com.jh.hotelbookingmanagement.repository;

import com.jh.hotelbookingmanagement.entity.BookingMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingMethodRepository extends JpaRepository<BookingMethod, Integer> {
}
