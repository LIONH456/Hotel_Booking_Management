package com.jh.hotelbookingmanagement.dto.request;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.jh.hotelbookingmanagement.validator.DobConstraint;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    String password;
    String firstName;
    String lastName;

    @DobConstraint(min = 18, message = "INVALID_DOB")
    LocalDate dob;
    String gender;
    String address;
    String email;
    String phoneNum;
    String identificationNum;
    String identificationType;
    String nationality;
    String registerType;
    Date updatedDate;

    List<String> roles;
}
