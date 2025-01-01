package com.jh.hotelbookingmanagement.dto.request;

import com.jh.hotelbookingmanagement.entity.ProvidedServices;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceUsageRequest {
    String bookingDetailId;
    Long serviceId;
    Date serviceUsedDate;
    int quantity;
}
