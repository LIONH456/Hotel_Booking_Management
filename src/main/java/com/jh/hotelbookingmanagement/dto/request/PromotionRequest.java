package com.jh.hotelbookingmanagement.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PromotionRequest {
    String promotionName;
    Date startDate;
    Date endDate;
    double discount;
    String description;
}
