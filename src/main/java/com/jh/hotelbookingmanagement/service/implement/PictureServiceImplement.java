package com.jh.hotelbookingmanagement.service.implement;

import com.jh.hotelbookingmanagement.dto.response.PictureResponse;
import com.jh.hotelbookingmanagement.entity.Picture;
import com.jh.hotelbookingmanagement.entity.PictureCategory;
import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import com.jh.hotelbookingmanagement.mapper.PictureMapper;
import com.jh.hotelbookingmanagement.repository.PictureCategoryRepository;
import com.jh.hotelbookingmanagement.repository.PictureRepository;
import com.jh.hotelbookingmanagement.service.PictureService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PictureServiceImplement implements PictureService {
    private final PictureCategoryRepository pictureCategoryRepository;
    PictureRepository pictureRepository;
    PictureMapper pictureMapper;

    @NonFinal
    @Value("${picture.upload-dir}")
    protected String UPLOAD_DIR;

    @Override
    public PictureResponse uploadPicture(MultipartFile file, String category) {
        // check if the file is validated
        validateFile(file);

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(UPLOAD_DIR, fileName);
        PictureCategory pictureCategory = pictureCategoryRepository.findById(category.toUpperCase()).orElseThrow(()->new AppException(ErrorCode.INVALID_PICTURE_CATEGORY));

        Picture picture = Picture.builder() // Call the static builder() method on the class
                .path(filePath.toString())
                .name(fileName)
                .uploadDate(new Date())
                .category(pictureCategory)
                .build();
        try {
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, file.getBytes());
        } catch (IOException e) {
            throw new AppException(ErrorCode.FILE_SAVE_FAILED);
        }
        return pictureMapper.toPictureResponse(pictureRepository.save(picture));
    }

    @Override
    public List<Picture> getAllPictures() {
        return pictureRepository.findAll();
    }

    @Override
    public List<Picture> getPicturesByCategory(String category) {
        return pictureRepository.findAllByCategoryCategoryName(category);
    }

    @Override
    public void deletePicture(Long pictureId) {
        Picture picture = pictureRepository.findById(pictureId)
                .orElseThrow(() -> new AppException(ErrorCode.FILE_PATH_INVALID));
        Path filePath = Paths.get(picture.getPath());

        try {
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            throw new AppException(ErrorCode.FILE_DELETE_FAILED);
        }

        pictureRepository.deleteById(pictureId);
    }

    private void validateFile(MultipartFile file) {
        if (file.isEmpty()) throw new AppException(ErrorCode.FILE_IS_EMPTY);

        String contentType = file.getContentType();
        if (!Arrays.asList("image/jpeg", "image/png").contains(contentType)) {
            throw new AppException(ErrorCode.FILE_NOT_SUPPORTED);
        }

        if (file.getSize() > 5 * 1024 * 1024) { // 5 MB
            throw new AppException(ErrorCode.FILE_SIZE_EXCEEDED);
        }
    }
}
