package com.jh.hotelbookingmanagement.dto.request;

import java.util.Date;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BranchCreationRequest {
    String managerId;
    String branchPhoneNum;
    String address;
    Date startedDate;
    Date lastMaintenance;
    String branchPicture;
}
