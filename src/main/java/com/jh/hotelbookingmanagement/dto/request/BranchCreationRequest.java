package com.jh.hotelbookingmanagement.dto.request;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BranchCreationRequest {
    String managerId;
    String branchPhoneNum;
    String numberOfRooms;
    String address;
    Date startedDate;
    Date lastMaintenance;
    String branchPicture;
}
