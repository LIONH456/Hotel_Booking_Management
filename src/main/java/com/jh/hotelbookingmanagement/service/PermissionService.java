package com.jh.hotelbookingmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jh.hotelbookingmanagement.dto.request.PermissionRequest;
import com.jh.hotelbookingmanagement.dto.response.PermissionResponse;
import com.jh.hotelbookingmanagement.entity.Permission;
import com.jh.hotelbookingmanagement.mapper.PermissionMapper;
import com.jh.hotelbookingmanagement.repository.PermissionRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

    public PermissionResponse create(PermissionRequest request) {
        Permission permission = permissionMapper.toPermission(request);
        permission = permissionRepository.save(permission);
        return permissionMapper.toPermissionResponse(permission);
    }

    public List<PermissionResponse> getAll() {
        var permissions = permissionRepository.findAll();
        return permissions.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    public void delete(String permission) {
        permissionRepository.deleteById(permission);
    }
}
