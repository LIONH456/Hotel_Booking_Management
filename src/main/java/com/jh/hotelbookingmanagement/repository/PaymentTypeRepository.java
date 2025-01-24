package com.jh.hotelbookingmanagement.repository;

import com.jh.hotelbookingmanagement.entity.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {
    Optional<PaymentType> findByPaymentTypeName(String paymentType);
}
