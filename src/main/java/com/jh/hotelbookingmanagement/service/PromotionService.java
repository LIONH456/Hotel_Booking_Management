package com.jh.hotelbookingmanagement.service;


import com.jh.hotelbookingmanagement.dto.request.PromotionRequest;
import com.jh.hotelbookingmanagement.dto.response.PromotionResponse;

import java.util.List;

public interface PromotionService {
    PromotionResponse createPromotion(PromotionRequest request);
    
    List<PromotionResponse> getAllPromotion();

    PromotionResponse updatePromotion(Long promotionId, PromotionRequest request);

    void deletePromotion(Long promotionId);
    
}
