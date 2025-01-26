package com.jh.hotelbookingmanagement.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class RevenueStats {
    Integer month;
    BigDecimal revenue;

    // Constructor for native query
    public RevenueStats(Object[] values) {
        this.month = values[0] != null ? ((Number) values[0]).intValue() : null;
        this.revenue = values[1] != null ? new BigDecimal(values[1].toString()) : BigDecimal.ZERO;
    }
} 