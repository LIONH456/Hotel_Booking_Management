package com.jh.hotelbookingmanagement.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.jh.hotelbookingmanagement.dto.request.BookingCreationRequest;
import com.jh.hotelbookingmanagement.dto.request.BookingUpdateRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingResponse;
import com.jh.hotelbookingmanagement.dto.response.BookingDetailResponse;
import com.jh.hotelbookingmanagement.entity.Booking;
import com.jh.hotelbookingmanagement.entity.BookingDetail;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    @Mapping(target = "bookedBy", ignore = true)
    @Mapping(target = "bookingMethod", ignore = true)
    Booking toBooking(BookingCreationRequest request);

    @Mapping(target = "bookingMethodName", source = "bookingMethod.bookingMethodName")
    @Mapping(target = "bookedByUsername", source = "bookedBy.username")
    @Mapping(target = "bookingDetails", source = "bookingDetails")
    BookingResponse toBookingResponse(Booking booking);

    List<BookingResponse> toBookingResponse(List<Booking> bookings);

    @Mapping(target = "bookedBy", ignore = true)
    void updateBooking(@MappingTarget Booking booking, BookingUpdateRequest request);

    @Mapping(target = "bookingId", source = "booking.bookingId")
    @Mapping(target = "roomId", source = "room.roomId")
    @Mapping(target = "bookingStatus", source = "bookingStatus.bookingStatus")
    BookingDetailResponse toBookingDetailResponse(BookingDetail bookingDetail);
}
