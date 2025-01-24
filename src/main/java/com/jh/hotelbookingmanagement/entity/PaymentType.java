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
@Table(name = "payment_types")
public class PaymentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="payment_type_id")
    private Long paymentTypeId;
    
    @Column(name = "payment_type", unique = true)
    private String paymentTypeName;
    
    private String description;
    private Boolean active;

    @OneToMany(mappedBy = "paymentType")
    private List<Payment> payments;
}
