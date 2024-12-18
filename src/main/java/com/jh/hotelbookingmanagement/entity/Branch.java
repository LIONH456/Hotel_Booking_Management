package com.jh.hotelbookingmanagement.entity;

import java.util.Date;
import java.util.List;

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

    @OneToOne
    @JoinColumn(name = "Manager_ID", referencedColumnName = "User_ID")
    User managerId;

    @Column(name = "Branch_Phone_Num")
    String branchPhoneNum;

    @Column(name = "NumberOfRooms")
    String numberOfRooms;

    @Column(name = "Address")
    String address;

    @Column(name = "Started_Date")
    Date startedDate;

    @Column(name = "Last_Maintenance_Date")
    Date lastMaintenance;

    @ManyToMany
    @JoinTable(
            name = "branch_pictures",
            joinColumns = @JoinColumn(name = "branch_id"),
            inverseJoinColumns = @JoinColumn(name = "picture_id")
    )
    List<Picture> pictures;
}
