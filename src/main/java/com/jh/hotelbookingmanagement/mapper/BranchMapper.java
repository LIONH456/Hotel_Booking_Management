package com.jh.hotelbookingmanagement.mapper;

import com.jh.hotelbookingmanagement.dto.request.BookingCreationRequest;
import com.jh.hotelbookingmanagement.dto.request.BookingUpdateRequest;
import com.jh.hotelbookingmanagement.dto.request.BranchCreationRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingResponse;
import com.jh.hotelbookingmanagement.dto.response.BranchResponse;
import com.jh.hotelbookingmanagement.entity.Booking;
import com.jh.hotelbookingmanagement.entity.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BranchMapper {
    Branch toBranch(BranchCreationRequest request);

    BranchResponse toBranchingResponse(Booking booking);
    List<BranchResponse> toBranchRespone(List<Booking> bookings);

    void updateBranch(@MappingTarget Branch branch, BookingUpdateRequest request);
}
