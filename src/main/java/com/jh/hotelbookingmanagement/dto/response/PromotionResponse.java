package com.jh.hotelbookingmanagement.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PromotionResponse {
    Long promotionId;
    String promotionName;
    Date startDate;
    Date endDate;
    double discount;
    String description;
}
