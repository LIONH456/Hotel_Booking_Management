package com.jh.hotelbookingmanagement.service;

import com.jh.hotelbookingmanagement.dto.response.PictureResponse;
import com.jh.hotelbookingmanagement.dto.response.PictureUploadResponse;
import com.jh.hotelbookingmanagement.entity.Picture;
import com.jh.hotelbookingmanagement.entity.PictureCategory;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Locale;

public interface PictureService {
    PictureResponse uploadPicture(MultipartFile file, String category) throws Exception;
    List<Picture> getAllPictures();
    List<Picture> getPicturesByCategory(String category);
    void deletePicture(Long pictureId) throws Exception;
}
