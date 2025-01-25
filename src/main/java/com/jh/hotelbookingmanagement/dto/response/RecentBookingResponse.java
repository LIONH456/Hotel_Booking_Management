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
public class RecentBookingResponse {
    private String id;
    private String guestName;
    private String roomType;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private double amount;
    private String status;
    private String paymentStatus;
} 