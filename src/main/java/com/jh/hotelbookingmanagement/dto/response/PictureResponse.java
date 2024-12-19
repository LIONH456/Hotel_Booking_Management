package com.jh.hotelbookingmanagement.dto.response;

import com.jh.hotelbookingmanagement.entity.PictureCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PictureResponse {
    Long pictureId;
    String name;
    String path;
    Date uploadDate;
    String category;
}
