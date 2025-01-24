package com.jh.hotelbookingmanagement.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="User_ID")
    String userId;

    @Column(name = "username", unique = true, columnDefinition = "VARCHAR(255) COLLATE utf8mb4_unicode_ci")
    String username;

    String password;
    String firstName;
    LocalDate dob;
    String lastName;

    String gender;
    String address;
    String email;
    String phoneNum;
    String identificationNum;
    String identificationType;
    String nationality;
    String registerType;
    Date createdDate;
    Date updatedDate;

    @ManyToMany
    Set<Role> roles;
}
