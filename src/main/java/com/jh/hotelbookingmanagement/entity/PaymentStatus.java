package com.jh.hotelbookingmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment_status")
public class PaymentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_status_id")
    private Long paymentStatusId;
    
    @Column(name = "payment_status", unique = true)
    private String paymentStatus;
    
    private String description;

    @OneToMany(mappedBy = "paymentStatus")
    private List<Payment> payments;
} 