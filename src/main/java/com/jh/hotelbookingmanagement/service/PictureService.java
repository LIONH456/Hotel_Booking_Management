package com.jh.hotelbookingmanagement.service;

import com.jh.hotelbookingmanagement.dto.response.PictureUploadResponse;
import com.jh.hotelbookingmanagement.entity.Picture;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PictureService {
    public PictureUploadResponse savePicture(MultipartFile file, Picture picture);

    PictureUploadResponse uploadPicture(MultipartFile file);

    public List<Picture> getPicturesByCategory(String category);

    public void deletePicture(Long pictureId);

}
