package com.jh.hotelbookingmanagement.service.implement;

import com.jh.hotelbookingmanagement.dto.request.PromotionRequest;
import com.jh.hotelbookingmanagement.dto.response.PromotionResponse;
import com.jh.hotelbookingmanagement.entity.Promotion;
import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import com.jh.hotelbookingmanagement.mapper.PromotionMapper;
import com.jh.hotelbookingmanagement.repository.PromotionRepository;
import com.jh.hotelbookingmanagement.service.PromotionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class PromotionServiceImplement implements PromotionService {
    PromotionRepository promotionRepository;
    PromotionMapper promotionMapper;

    @Override
    public PromotionResponse createPromotion(PromotionRequest request) {
        Promotion promotion = promotionMapper.toPromotion(request);

        promotion = promotionRepository.save(promotion);
        return promotionMapper.toPromotionResponse(promotion);
    }

    @Override
    public List<PromotionResponse> getAllPromotion() {
        return promotionRepository.findAll().stream()
                .map(promotionMapper::toPromotionResponse).toList();
    }

    @Override
    public PromotionResponse updatePromotion(Long promotionId, PromotionRequest request) {
        Promotion promotion = promotionRepository.findById(promotionId)
                .orElseThrow(()->new AppException(ErrorCode.BOOKING_METHOD_NOT_FOUND));
        promotionMapper.updatePromotion(promotion, request);
        return promotionMapper.toPromotionResponse(promotionRepository.save(promotion));
    }

    @Override
    public void deletePromotion(Long promotionId) {
        promotionRepository.deleteById(promotionId);
    }
}
