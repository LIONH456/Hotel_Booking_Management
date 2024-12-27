package com.jh.hotelbookingmanagement.service;


import com.jh.hotelbookingmanagement.dto.request.BookingMethodRequest;
import com.jh.hotelbookingmanagement.dto.request.ProvidedServicesRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingMethodResponse;
import com.jh.hotelbookingmanagement.dto.response.ProvidedServicesResponse;

import java.util.List;

public interface ProvidedServicesService {
    ProvidedServicesResponse createProvidedServices(ProvidedServicesRequest request);

    List<ProvidedServicesResponse> getAllProvidedServices();

    ProvidedServicesResponse updateProvidedServices(Long providedServicesId, ProvidedServicesRequest request);

    void deleteProvidedServices(Long providedServicesId);

    public ProvidedServicesResponse getProvidedServices(Long providedServicesId);
    
}
