package com.jh.hotelbookingmanagement.entity;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "Payment_Types")
public class PaymentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Payment_Type_ID")
    int paymentTypeId;

    @Column(name = "Payment_Type")
    String paymentTypeName;

    @Column(name = "Description")
    String description;

    @Column(name = "Active")
    boolean active;
}
