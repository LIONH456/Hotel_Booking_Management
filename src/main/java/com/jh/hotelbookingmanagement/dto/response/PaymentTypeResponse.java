package com.jh.hotelbookingmanagement.dto.response;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentTypeResponse {
    Long paymentTypeId;
    String paymentTypeName;
    String description;
    boolean active;
}
