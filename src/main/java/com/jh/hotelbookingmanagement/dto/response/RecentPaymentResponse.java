package com.jh.hotelbookingmanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecentPaymentResponse {
    private String id;
    private String bookingId;
    private String customerName;
    private Double amount;
    private String paymentMethod;
    private LocalDateTime paymentDate;
    private String status;
} 