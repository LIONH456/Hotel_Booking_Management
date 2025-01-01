package com.jh.hotelbookingmanagement.mapper;

import com.jh.hotelbookingmanagement.dto.request.ServiceUsageRequest;
import com.jh.hotelbookingmanagement.dto.response.ServiceUsageResponse;
import com.jh.hotelbookingmanagement.entity.ServiceUsage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ServiceUsageMapper {
    @Mapping(target = "bookingDetail", ignore = true)
    ServiceUsage toServiceUsage(ServiceUsageRequest request);

    @Mapping(target = "bookingDetailId", source = "bookingDetail.bookingDetailId")
    @Mapping(target = "service", source = "service")
    ServiceUsageResponse toServiceUsageResponse(ServiceUsage serviceUsage);

    void updateServiceUsage(@MappingTarget ServiceUsage serviceUsage, ServiceUsageRequest request);
}
