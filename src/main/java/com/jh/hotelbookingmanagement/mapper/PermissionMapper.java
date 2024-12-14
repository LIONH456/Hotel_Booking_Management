package com.jh.hotelbookingmanagement.mapper;

import org.mapstruct.Mapper;

import com.jh.hotelbookingmanagement.dto.request.PermissionRequest;
import com.jh.hotelbookingmanagement.dto.response.PermissionResponse;
import com.jh.hotelbookingmanagement.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
