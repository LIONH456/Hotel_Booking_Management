package com.jh.hotelbookingmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jh.hotelbookingmanagement.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, String> {
}
