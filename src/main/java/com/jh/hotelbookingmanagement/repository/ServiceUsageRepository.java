package com.jh.hotelbookingmanagement.repository;

import com.jh.hotelbookingmanagement.entity.ServiceUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceUsageRepository extends JpaRepository<ServiceUsage, String> {

    // Get Unit Price based On Item ID
    @Query(value = "SELECT price FROM services WHERE service_id = :serviceId", nativeQuery = true)
    double getUnitPriceByServiceId(@Param("serviceId") Long serviceId);

    // Update the service charge in booking detail
    @Modifying
    @Query(value = "UPDATE booking_details SET service_charge = (SELECT SUM(charge) FROM service_usage WHERE booking_detail_id = :bookingDetailId), total_amount = total_room_charge + item_charge + service_charge WHERE booking_detail_id = :bookingDetailId", nativeQuery = true)
    void updateServiceCharge(@Param("bookingDetailId") String bookingDetailId);
}
