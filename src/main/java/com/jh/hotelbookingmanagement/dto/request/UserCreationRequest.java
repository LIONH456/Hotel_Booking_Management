package com.jh.hotelbookingmanagement.dto.request;

import java.time.LocalDate;
import java.util.Date;

import jakarta.validation.constraints.Size;

import com.jh.hotelbookingmanagement.validator.DobConstraint;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(min = 4, message = "USERNAME_INVALID")
    String username;

    @Size(min = 6, message = "INVALID_PASSWORD")
    String password;

    String firstName;
    String lastName;

    @DobConstraint(min = 10, message = "INVALID_DOB")
    LocalDate dob;

    String gender;
    String address;
    String email;
    String phoneNum;
    String identificationNum;
    String identificationType;
    String nationality;
    String registerType;
    Date createdDate;

}
