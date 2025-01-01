package com.jh.hotelbookingmanagement.service;


import com.jh.hotelbookingmanagement.dto.request.ServiceUsageRequest;
import com.jh.hotelbookingmanagement.dto.response.ServiceUsageResponse;

import java.util.List;

public interface ServiceUsageService {
    ServiceUsageResponse createServiceUsage(ServiceUsageRequest request);
    
    List<ServiceUsageResponse> getAllServiceUsage();

    ServiceUsageResponse updateServiceUsage(String serviceUsageId, ServiceUsageRequest request);

    void deleteServiceUsage(String serviceUsageId);
    
}
