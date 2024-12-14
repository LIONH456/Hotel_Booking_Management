package com.jh.hotelbookingmanagement.dto.response;

import java.util.Set;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleResponse {
    String userRoleId;
    String name;
    String description;
    Set<PermissionResponse> permissions;
}
