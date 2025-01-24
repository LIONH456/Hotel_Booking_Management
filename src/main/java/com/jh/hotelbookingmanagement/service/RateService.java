package com.jh.hotelbookingmanagement.service;


import com.jh.hotelbookingmanagement.dto.request.RateRequest;
import com.jh.hotelbookingmanagement.dto.response.RateResponse;

import java.util.List;

public interface RateService {
    RateResponse createRate(RateRequest request);
    
    List<RateResponse> getAllRate();

    RateResponse updateRate(Long rateId, RateRequest request);

    void deleteRate(Long rateId);
    
}
