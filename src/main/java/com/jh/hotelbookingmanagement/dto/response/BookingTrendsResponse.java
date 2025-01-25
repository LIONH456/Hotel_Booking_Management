package com.jh.hotelbookingmanagement.dto.response;

import lombok.Builder;
import lombok.Data;
import java.util.List;
import java.util.Map;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingTrendsResponse {
    private List<MonthlyBookingData> monthlyBookings;
    private Map<String, Integer> bookingsByType;
    private Map<String, Long> bookingsByMethod;
}

