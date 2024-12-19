package com.jh.hotelbookingmanagement.controller;
import com.jh.hotelbookingmanagement.dto.request.ApiResponse;
import com.jh.hotelbookingmanagement.dto.response.PictureResponse;
import com.jh.hotelbookingmanagement.entity.Picture;
import com.jh.hotelbookingmanagement.service.PictureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/pictures")
@RequiredArgsConstructor
public class PictureController {

    private final PictureService pictureService;

    @PostMapping("/upload")
    public ApiResponse<PictureResponse> uploadPicture(@RequestParam MultipartFile file,
                                              @RequestParam String category) throws Exception {
        return ApiResponse.<PictureResponse>builder()
                .result(pictureService.uploadPicture(file, category))
                .build();
    }

    @GetMapping
    public ApiResponse<List<Picture>> getAllPictures() {
        return ApiResponse.<List<Picture>>builder()
                .result(pictureService.getAllPictures())
                .build();
    }

    @GetMapping("/category/{category}")
    public ApiResponse<List<Picture>> getPicturesByCategory(@PathVariable String category) {
        return ApiResponse.<List<Picture>>builder()
                .result(pictureService.getPicturesByCategory(category))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deletePicture(@PathVariable Long id) throws Exception {
        pictureService.deletePicture(id);
        return ApiResponse.<String>builder()
                .result("Picture deleted successfully")
                .build();
    }
}
