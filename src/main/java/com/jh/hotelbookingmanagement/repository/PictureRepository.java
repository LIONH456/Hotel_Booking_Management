package com.jh.hotelbookingmanagement.repository;

import com.jh.hotelbookingmanagement.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
    List<Picture> findAllByCategoryCategoryName(String categoryName);
}
