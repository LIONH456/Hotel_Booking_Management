package com.jh.hotelbookingmanagement.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentStatusRequest {
    String paymentStatus;
    String description;
} 