package com.jh.hotelbookingmanagement.dto.request;

import com.jh.hotelbookingmanagement.entity.BookingDetail;
import com.jh.hotelbookingmanagement.entity.RoomItem;
import com.jh.hotelbookingmanagement.validator.DobConstraint;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomItemUsageRequest {
    Long itemId;
    String bookingDetailId;

    @Min(value = 1, message = "INSUFFICIENT_QUANTITY")
    int quantity;
}
