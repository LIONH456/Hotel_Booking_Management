package com.jh.hotelbookingmanagement.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
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
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "username", unique = true, columnDefinition = "VARCHAR(255) COLLATE utf8mb4_unicode_ci")
    private String username;

    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private LocalDate dob;

    private String email;

    @Column(name = "phone_num")
    private String phoneNum;

    private String address;

    private String gender;

    private String nationality;

    @Column(name = "identification_num")
    private String identificationNum;

    @Column(name = "identification_type")
    private String identificationType;

    @Column(name = "register_type")
    private String registerType;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @OneToMany(mappedBy = "bookedBy")
    private List<Booking> bookings;

    @ManyToMany
    Set<Role> roles;
}
