package com.jh.hotelbookingmanagement.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MonthlyBookingData {
    private String month;
    private int bookingCount;
    private double revenue;
}
