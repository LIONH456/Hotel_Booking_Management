package com.jh.hotelbookingmanagement.mapper;

import com.jh.hotelbookingmanagement.dto.request.PictureRequest;
import com.jh.hotelbookingmanagement.dto.response.PictureResponse;
import com.jh.hotelbookingmanagement.entity.Picture;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PictureMapper {

    // Picture toPicture(PictureRequest request);
    @Mapping(target = "category", source = "category.categoryName")
    PictureResponse toPictureResponse(Picture picture);
}
