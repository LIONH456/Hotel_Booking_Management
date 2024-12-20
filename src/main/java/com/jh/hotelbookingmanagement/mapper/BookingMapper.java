package com.jh.hotelbookingmanagement.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.jh.hotelbookingmanagement.dto.request.BookingCreationRequest;
import com.jh.hotelbookingmanagement.dto.request.BookingUpdateRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingResponse;
import com.jh.hotelbookingmanagement.entity.Booking;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    @Mapping(target = "bookedBy", ignore = true)
    Booking toBooking(BookingCreationRequest request);

    BookingResponse toBookingResponse(Booking booking);

    List<BookingResponse> toBookingResponse(List<Booking> bookings);

    @Mapping(target = "bookedBy", ignore = true)
    void updateBooking(@MappingTarget Booking booking, BookingUpdateRequest request);
}
