package com.jh.hotelbookingmanagement.mapper;

import com.jh.hotelbookingmanagement.dto.request.PromotionRequest;
import com.jh.hotelbookingmanagement.dto.response.PromotionResponse;
import com.jh.hotelbookingmanagement.entity.Promotion;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PromotionMapper {

    Promotion toPromotion(PromotionRequest request);
    PromotionResponse toPromotionResponse(Promotion promotion);
    void updatePromotion(@MappingTarget Promotion promotion, PromotionRequest request);
}
