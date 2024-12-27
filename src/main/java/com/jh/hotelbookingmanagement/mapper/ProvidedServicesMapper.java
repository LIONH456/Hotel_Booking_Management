package com.jh.hotelbookingmanagement.mapper;

import com.jh.hotelbookingmanagement.dto.request.ProvidedServicesRequest;
import com.jh.hotelbookingmanagement.dto.response.ProvidedServicesResponse;
import com.jh.hotelbookingmanagement.entity.ProvidedServices;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProvidedServicesMapper {

    ProvidedServices toProvidedServices(ProvidedServicesRequest request);
    ProvidedServicesResponse toProvidedServicesResponse(ProvidedServices providedServices);
    void updateProvidedServices(@MappingTarget ProvidedServices providedServices, ProvidedServicesRequest request);
}
