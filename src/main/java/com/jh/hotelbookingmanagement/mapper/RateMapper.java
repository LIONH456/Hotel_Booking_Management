package com.jh.hotelbookingmanagement.mapper;

import com.jh.hotelbookingmanagement.dto.request.RateRequest;
import com.jh.hotelbookingmanagement.dto.response.RateResponse;
import com.jh.hotelbookingmanagement.entity.Rate;
import com.jh.hotelbookingmanagement.entity.Rate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RateMapper {

    @Mapping(target="ratedBy", ignore = true)
//    @Mapping(target = "room", ignore = true)
    Rate toRate(RateRequest request);

    @Mapping(target = "ratedBy", source = "ratedBy")
    RateResponse toRateResponse(Rate rate);
    @Mapping(target="ratedBy", ignore = true)
    void updateRate(@MappingTarget Rate rate, RateRequest request);
}
