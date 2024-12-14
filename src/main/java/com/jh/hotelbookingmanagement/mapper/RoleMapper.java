package com.jh.hotelbookingmanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jh.hotelbookingmanagement.dto.request.RoleRequest;
import com.jh.hotelbookingmanagement.dto.response.RoleResponse;
import com.jh.hotelbookingmanagement.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
