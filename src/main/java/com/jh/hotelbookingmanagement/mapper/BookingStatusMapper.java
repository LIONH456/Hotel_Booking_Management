package com.jh.hotelbookingmanagement.mapper;

import com.jh.hotelbookingmanagement.dto.request.BookingMethodRequest;
import com.jh.hotelbookingmanagement.dto.request.BookingStatusRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingMethodResponse;
import com.jh.hotelbookingmanagement.dto.response.BookingStatusResponse;
import com.jh.hotelbookingmanagement.entity.BookingMethod;
import com.jh.hotelbookingmanagement.entity.BookingStatus;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookingStatusMapper {

    BookingStatus toBookingStatus(BookingStatusRequest request);
    BookingStatusResponse toBookingStatusResponse(BookingStatus bookingStatus);
    void updateBookingStatus(@MappingTarget BookingStatus bookingStatus, BookingStatusRequest request);
}
