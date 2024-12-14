package com.jh.hotelbookingmanagement.repository;
import com.jh.hotelbookingmanagement.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BranchRepository extends JpaRepository<Branch, String> {
}
