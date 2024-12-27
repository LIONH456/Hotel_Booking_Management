package com.jh.hotelbookingmanagement.repository;

import com.jh.hotelbookingmanagement.entity.ProvidedServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvidedServicesRepository extends JpaRepository<ProvidedServices, Long> {
    boolean existsByServiceName(String roomServicesName);
}
