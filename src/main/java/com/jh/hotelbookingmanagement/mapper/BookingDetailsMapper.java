package com.jh.hotelbookingmanagement.mapper;

import com.jh.hotelbookingmanagement.dto.request.BookingCreationRequest;
import com.jh.hotelbookingmanagement.dto.request.BookingDetailRequest;
import com.jh.hotelbookingmanagement.dto.request.BookingDetailUpdateRequest;
import com.jh.hotelbookingmanagement.dto.request.BookingUpdateRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingDetailResponse;
import com.jh.hotelbookingmanagement.dto.response.BookingResponse;
import com.jh.hotelbookingmanagement.entity.Booking;
import com.jh.hotelbookingmanagement.entity.BookingDetail;
import com.jh.hotelbookingmanagement.entity.BookingStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingDetailsMapper {
    @Mapping(target = "bookingDetailId", ignore = true)
    @Mapping(target = "booking", ignore = true)
    @Mapping(target = "room", ignore = true)
    @Mapping(target = "bookingStatus", ignore = true)
    @Mapping(target = "itemCharge", constant = "0")
    @Mapping(target = "serviceCharge", constant = "0")
    @Mapping(target = "totalRoomCharge", constant = "0")
    @Mapping(target = "totalAmount", constant = "0")
    BookingDetail toBookingDetail(BookingDetailRequest request);

    @Mapping(target = "bookingId", source = "booking.bookingId")
    @Mapping(target = "roomId", source = "room.roomId")
    @Mapping(target = "bookingStatus", source = "bookingStatus.bookingStatus")
    BookingDetailResponse toBookingDetailResponse(BookingDetail bookingDetail);

    @Mapping(target = "booking", ignore = true)
    @Mapping(target = "room", ignore = true)
    @Mapping(target = "bookingStatus", ignore = true)
    void updateBookingDetail(@MappingTarget BookingDetail bookingDetail, BookingDetailUpdateRequest request);

    default String map(BookingStatus value) {
        return value != null ? value.getBookingStatus() : null;
    }
}
