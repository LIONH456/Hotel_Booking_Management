package com.jh.hotelbookingmanagement.dto.response;

import java.util.Date;
import java.util.List;
import java.util.Set;

import lombok.*;
import lombok.experimental.FieldDefaults;

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

    // For showing all room details
    List<RoomResponse> rooms;

    // For showing only room numbers
    Set<String> roomNumbers;
}
