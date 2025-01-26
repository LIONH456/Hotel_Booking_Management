package com.jh.hotelbookingmanagement.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

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
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="user_id")
    String userId;

    @Column(name = "username", unique = true, columnDefinition = "VARCHAR(255) COLLATE utf8mb4_unicode_ci")
    String username;

    String password;

    @Column(name = "First_Name")
    String firstName;

    @Column(name = "Date_Of_Birth")
    LocalDate dob;

    @Column(name = "Last_Name")
    String lastName;

    @Column(name = "Email")
    String email;

    @Column(name="Gender")
    String gender;

    @Column(name="Phone_Number")
    String phoneNumber;

    @ManyToMany
    Set<Role> roles;
}
