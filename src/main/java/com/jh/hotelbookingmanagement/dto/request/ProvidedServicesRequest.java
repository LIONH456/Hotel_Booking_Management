package com.jh.hotelbookingmanagement.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProvidedServicesRequest {
    String serviceName;
    String description;
    double servicePrice;
    boolean serviceActive;
}
