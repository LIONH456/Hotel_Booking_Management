package com.jh.hotelbookingmanagement.dto.response;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String userId;
    String username;
    String firstName;
    String lastName;
    LocalDate dob;
    String gender;
    String address;
    String email;
    String phoneNumber;
    String identificationNum;
    String identificationType;
    String nationality;
    String registerType;
    Date createdDate;
    Date updatedDate;
    Set<RoleResponse> roles;
}
