package com.jh.hotelbookingmanagement.repository;

import com.jh.hotelbookingmanagement.entity.BookingDetail;
import com.jh.hotelbookingmanagement.entity.PictureCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureCategoryRepository extends JpaRepository<PictureCategory, String> {
}
