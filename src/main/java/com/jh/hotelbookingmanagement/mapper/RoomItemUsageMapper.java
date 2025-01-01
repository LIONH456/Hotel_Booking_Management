package com.jh.hotelbookingmanagement.mapper;

import com.jh.hotelbookingmanagement.dto.request.BookingDetailRequest;
import com.jh.hotelbookingmanagement.dto.request.BookingDetailUpdateRequest;
import com.jh.hotelbookingmanagement.dto.request.RoomItemUsageRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingDetailResponse;
import com.jh.hotelbookingmanagement.dto.response.RoomItemUsageResponse;
import com.jh.hotelbookingmanagement.entity.BookingDetail;
import com.jh.hotelbookingmanagement.entity.RoomItemUsage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoomItemUsageMapper {
    @Mapping(target = "bookingDetail", ignore = true)
    RoomItemUsage toRoomItemUsage(RoomItemUsageRequest request);

    @Mapping(target = "bookingDetailId", source = "bookingDetail.bookingDetailId")
    @Mapping(target = "item", source = "item")
    RoomItemUsageResponse toRoomItemUsageResponse(RoomItemUsage roomItemUsage);

    void updateRoomItemUsage(@MappingTarget RoomItemUsage roomItemUsage, RoomItemUsageRequest request);
}
