package com.jh.hotelbookingmanagement.service.implement;

import java.util.HashSet;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jh.hotelbookingmanagement.constant.PredefinedRole;
import com.jh.hotelbookingmanagement.dto.request.UserCreationRequest;
import com.jh.hotelbookingmanagement.dto.request.UserUpdateRequest;
import com.jh.hotelbookingmanagement.dto.response.UserResponse;
import com.jh.hotelbookingmanagement.entity.Role;
import com.jh.hotelbookingmanagement.entity.User;
import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import com.jh.hotelbookingmanagement.mapper.UserMapper;
import com.jh.hotelbookingmanagement.repository.RoleRepository;
import com.jh.hotelbookingmanagement.repository.UserRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserService {
    UserRepository userRepository;
    RoleRepository roleRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    public UserResponse createUser(UserCreationRequest request) {
        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // Create a new HashSet for roles
        HashSet<Role> roles = new HashSet<>();
        
        // Find the USER role and add it if found
        Role userRole = roleRepository.findByName(PredefinedRole.USER_ROLE)
            .orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND));
        roles.add(userRole);
        
        user.setRoles(roles);

        try {
            user = userRepository.save(user);
        } catch (DataIntegrityViolationException exception) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        return userMapper.toUserResponse(user);
    }

    public UserResponse getMyInfo() {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        User user = userRepository.findByUsername(name).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        return userMapper.toUserResponse(user);
    }

    //@PostAuthorize("returnObject.username == authentication.name")
    public UserResponse updateUser(String userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        // First update the user with non-password fields
        userMapper.updateUser(user, request);
        
        // Only encode and update password if it's provided
        if (request.getPassword() != null && !request.getPassword().trim().isEmpty()) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }
        // If password is not provided, keep the existing password

        try {
            user = userRepository.save(user);
        } catch (DataIntegrityViolationException exception) {
            throw new AppException(ErrorCode.USER_UPDATE_FAILED);
        }

        return userMapper.toUserResponse(user);
    }

   // @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    // @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
    }

    //@PreAuthorize("hasRole('ADMIN')")
    public UserResponse getUser(String id) {
        return userMapper.toUserResponse(
                userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));
    }

    public List<UserResponse> getCustomers() {
        log.info("Fetching customers");
        return userRepository.findAll().stream()
            .filter(user -> user.getRoles().stream()
                .anyMatch(role -> role.getName().equals("CUSTOMER")))
            .map(userMapper::toUserResponse)
            .toList();
    }

    public UserResponse createCustomer(UserCreationRequest request) {
        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // Create a new HashSet for roles
        HashSet<Role> roles = new HashSet<>();
        
        // Find the CUSTOMER role and add it if found
        Role customerRole = roleRepository.findByName(PredefinedRole.CUSTOMER_ROLE)
            .orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND));
        roles.add(customerRole);
        
        user.setRoles(roles);

        try {
            user = userRepository.save(user);
        } catch (DataIntegrityViolationException exception) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        return userMapper.toUserResponse(user);
    }
}
