package com.jh.hotelbookingmanagement.mapper;

import com.jh.hotelbookingmanagement.dto.request.BookingCreationRequest;
import com.jh.hotelbookingmanagement.dto.request.BookingDetailRequest;
import com.jh.hotelbookingmanagement.dto.request.BookingDetailUpdateRequest;
import com.jh.hotelbookingmanagement.dto.request.BookingUpdateRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingDetailResponse;
import com.jh.hotelbookingmanagement.dto.response.BookingResponse;
import com.jh.hotelbookingmanagement.entity.Booking;
import com.jh.hotelbookingmanagement.entity.BookingDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingDetailsMapper {
    @Mapping(target = "booking", ignore = true)
    BookingDetail toBookingDetail(BookingDetailRequest request);

    @Mapping(target = "bookingId", source = "booking.bookingId")
    @Mapping(target = "roomNumber", source = "room.roomNumber")
    @Mapping(target = "branchId", source = "room.branch.branchId")
    BookingDetailResponse toBookingDetailResponse(BookingDetail bookingDetail);

    @Mapping(target = "booking", ignore = true)
    void updateBookingDetail(@MappingTarget BookingDetail bookingDetail, BookingDetailUpdateRequest request);
}
