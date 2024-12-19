package com.jh.hotelbookingmanagement.dto.request;

import com.jh.hotelbookingmanagement.entity.PictureCategory;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PictureRequest {
    String name;
    String path;
    PictureCategory category;
}
