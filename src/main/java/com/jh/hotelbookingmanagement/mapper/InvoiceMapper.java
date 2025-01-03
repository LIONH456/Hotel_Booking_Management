package com.jh.hotelbookingmanagement.mapper;

import com.jh.hotelbookingmanagement.dto.request.InvoiceRequest;
import com.jh.hotelbookingmanagement.dto.request.UserCreationRequest;
import com.jh.hotelbookingmanagement.dto.request.UserUpdateRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingDetailResponse;
import com.jh.hotelbookingmanagement.dto.response.InvoiceResponse;
import com.jh.hotelbookingmanagement.dto.response.UserResponse;
import com.jh.hotelbookingmanagement.entity.BookingDetail;
import com.jh.hotelbookingmanagement.entity.Invoice;
import com.jh.hotelbookingmanagement.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice toInvoice(InvoiceRequest request);

    @Mapping(target = "bookingId", source = "booking.bookingId")
    @Mapping(target = "roomCount", source = "booking.roomCount")
    @Mapping(target="bookedBy", source = "booking.bookedBy.firstName")
    @Mapping(target= "bookingDetails", source = "booking.bookingDetails")
    InvoiceResponse toInvoiceResponse(Invoice invoice);





//    @Mapping(target = "roles", ignore = true)
//    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
