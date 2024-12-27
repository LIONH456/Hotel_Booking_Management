package com.jh.hotelbookingmanagement.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProvidedServicesResponse {
    Long serviceId;
    String serviceName;
    String description;
    double servicePrice;
    boolean serviceActive;
}
