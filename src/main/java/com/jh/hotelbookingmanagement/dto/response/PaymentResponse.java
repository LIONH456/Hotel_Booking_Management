package com.jh.hotelbookingmanagement.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentResponse {
    String paymentId;
    Double amount;
    Double discount;
    Double itemCharges;
    Double serviceCharges;
    Double total;
    Double totalPaid;
    LocalDateTime paidDate;
    String bookingId;
    String paymentType;
    String paymentStatus;
} 