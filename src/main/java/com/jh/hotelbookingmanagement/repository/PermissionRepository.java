package com.jh.hotelbookingmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jh.hotelbookingmanagement.entity.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {}
