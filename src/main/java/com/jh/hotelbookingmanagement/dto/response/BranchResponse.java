package com.jh.hotelbookingmanagement.dto.response;

import com.jh.hotelbookingmanagement.entity.BookingMethod;
import com.jh.hotelbookingmanagement.entity.BookingStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class BranchResponse {
    String branchId;
    String managerId;
    String branchPhoneNum;
    String numberOfRooms;
    String address;
    Date startedDate;
    Date lastMaintenance;
    String branchPicture;
}
