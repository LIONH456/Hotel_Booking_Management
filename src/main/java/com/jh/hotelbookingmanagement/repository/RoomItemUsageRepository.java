package com.jh.hotelbookingmanagement.repository;

import com.jh.hotelbookingmanagement.entity.RoomItemUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomItemUsageRepository extends JpaRepository<RoomItemUsage, String> {
    // Get Total Stock based on Item ID
    @Query(value = "SELECT stock FROM room_item WHERE item_id = :itemId", nativeQuery = true)
    int getStockByItemId(@Param("itemId") Long itemId);

    // Get Unit Price based On Item ID
    @Query(value = "SELECT price FROM room_item WHERE item_id = :itemId", nativeQuery = true)
    double getUnitPriceByItemId(@Param("itemId") Long itemId);

    @Modifying // Indicate a data modification operation
    @Query(value = "UPDATE room_item SET stock = stock - :stockChange WHERE item_id = :itemId", nativeQuery = true)
    void updateStock(@Param("stockChange") int stockChange, @Param("itemId") Long itemId);

    @Modifying
    @Query(value = "UPDATE booking_details SET item_charge = (SELECT SUM(charge) FROM room_item_usage WHERE booking_detail_id = :bookingDetailId ) WHERE booking_detail_id = :bookingDetailId", nativeQuery = true)
    void updateItemCharge(@Param("bookingDetailId") String bookingDetailId);

}
