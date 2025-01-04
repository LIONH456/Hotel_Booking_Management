package com.jh.hotelbookingmanagement.dto.response;

import com.jh.hotelbookingmanagement.entity.Room;
import com.jh.hotelbookingmanagement.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class RateResponse {
    Long rateId;
    Room room;
    User ratedBy;
    Date rateDate;
    int rateStars;
    String feedback;
}
