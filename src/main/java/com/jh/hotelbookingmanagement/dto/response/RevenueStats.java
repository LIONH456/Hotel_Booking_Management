package com.jh.hotelbookingmanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RevenueStats {
    private LocalDate date;
    private double revenue;
    private int bookingCount;
    
    public RevenueStats(int year, int month, double revenue) {
        this.date = LocalDate.of(year, month, 1);
        this.revenue = revenue;
        this.bookingCount = 0; // 可以根据需要设置
    }
} 