package com.jh.hotelbookingmanagement.repository;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jh.hotelbookingmanagement.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);

//    @Query("SELECT COUNT(u) FROM User u WHERE u.createdAt >= :startDate AND u.createdAt <= :endDate")
//    long countNewUsers(LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT COUNT(u) FROM User u " +
           "JOIN roles r " +
           "WHERE r.name = 'USER'")
    long countCustomers();
}
