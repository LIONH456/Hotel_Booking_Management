package com.jh.hotelbookingmanagement.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardStatsResponse {
    private List<StatCard> stats;
    private ChartData revenueChart;
    private Long totalRooms;
    private Long occupiedRooms;
    private Double todayRevenue;
    private Long todayBookings;
    
    @Data
    @Builder
    public static class StatCard {
        private String title;
        private String value;
        private String thisMonth;
        private String thisWeek;
        private ChartData chart;
    }
    
    @Data
    @Builder
    public static class ChartData {
        private List<String> labels;
        private List<Dataset> datasets;
        
        @Data
        @Builder
        public static class Dataset {
            private String label;
            private List<Number> data;
            private String borderColor;
            private String backgroundColor;
        }
    }
}
