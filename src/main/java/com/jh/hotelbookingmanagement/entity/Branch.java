package com.jh.hotelbookingmanagement.entity;

import java.util.Date;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "Branches")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Branch_ID")
    String branchId;

    @Column(name = "Manager_ID")
    String managerId;

    @Column(name = "Branch_Phone_Num")
    String branchPhoneNum;

    @Column(name = "NumberOfRooms")
    String numberOfRooms;

    @Column(name = "Address")
    String address;

    @Column(name = "Started_Date")
    Date startedDate;

    @Column(name = "Last_Metenanance")
    Date lastMaintenance;

    @Column(name = "Branch_Picture")
    String branchPicture;
}
