package com.jh.hotelbookingmanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecentCustomerResponse {
    private String id;
    private String name;
    private String email;
    private String phone;
    private LocalDateTime registrationDate;
    private String status;
    private boolean verified;
} 