package com.jh.hotelbookingmanagement.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.jh.hotelbookingmanagement.dto.request.BookingCreationRequest;
import com.jh.hotelbookingmanagement.dto.request.BookingUpdateRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingResponse;
import com.jh.hotelbookingmanagement.entity.Booking;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    Booking toBooking(BookingCreationRequest request);

    BookingResponse toBookingResponse(Booking booking);

    List<BookingResponse> toBookingResponse(List<Booking> bookings);

    void updateBooking(@MappingTarget Booking booking, BookingUpdateRequest request);
}
