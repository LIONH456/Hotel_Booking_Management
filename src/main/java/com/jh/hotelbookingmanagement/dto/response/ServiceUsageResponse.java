package com.jh.hotelbookingmanagement.dto.response;

import com.jh.hotelbookingmanagement.entity.ProvidedServices;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceUsageResponse {
    String serviceUsageId;
    String bookingDetailId;
    ProvidedServices service;
    Date serviceUsedDate;
    int quantity;
    double serviceCharge;
}
