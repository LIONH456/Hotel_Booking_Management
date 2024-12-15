package com.jh.hotelbookingmanagement.dto.request;

import java.util.Date;

import lombok.*;
import lombok.experimental.FieldDefaults;

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
