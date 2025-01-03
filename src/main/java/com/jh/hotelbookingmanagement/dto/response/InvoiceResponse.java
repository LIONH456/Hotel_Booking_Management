package com.jh.hotelbookingmanagement.dto.response;

import com.jh.hotelbookingmanagement.entity.BookingDetail;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InvoiceResponse {
    String invoiceId;
    String bookingId;
    Date invoiceDate;
    double totalAmount;
    double promotionInPercentage;
    double discountedAmount;
    double tax;
    double finalAmount;
    String roomCount;
    String bookedBy;
    List<BookingDetailResponse> bookingDetails;
}
