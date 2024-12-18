package com.jh.hotelbookingmanagement.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PictureUploadResponse{
    String filePath;       // Path to the uploaded file
    String fileName;       // Name of the uploaded file
    long fileSize;         // Size of the uploaded file (in bytes)
}
