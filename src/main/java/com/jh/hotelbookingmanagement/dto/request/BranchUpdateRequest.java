package com.jh.hotelbookingmanagement.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BranchUpdateRequest {
    String managerId;
    String branchPhoneNum;
    String numberOfRooms;
    String address;
    Date lastMaintenance;
    String branchPicture;
}
