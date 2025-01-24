package com.jh.hotelbookingmanagement.repository;

import com.jh.hotelbookingmanagement.entity.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentStatusRepository extends JpaRepository<PaymentStatus, Long> {
    PaymentStatus findByPaymentStatus(String status);
} 