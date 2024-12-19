package com.jh.hotelbookingmanagement.service;

import com.jh.hotelbookingmanagement.dto.response.PictureResponse;
import com.jh.hotelbookingmanagement.entity.Picture;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PictureService {
    PictureResponse uploadPicture(MultipartFile file, String category);
    List<Picture> getAllPictures();
    List<Picture> getPicturesByCategory(String category);
    void deletePicture(Long pictureId);
}
