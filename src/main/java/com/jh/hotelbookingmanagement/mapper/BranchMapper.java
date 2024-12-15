package com.jh.hotelbookingmanagement.mapper;

import java.util.List;

import com.jh.hotelbookingmanagement.dto.request.RoomCreationRequest;
import com.jh.hotelbookingmanagement.dto.request.RoomUpdateRequest;
import com.jh.hotelbookingmanagement.dto.response.RoomResponse;
import com.jh.hotelbookingmanagement.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.jh.hotelbookingmanagement.dto.request.BranchCreationRequest;
import com.jh.hotelbookingmanagement.dto.request.BranchUpdateRequest;
import com.jh.hotelbookingmanagement.dto.response.BranchResponse;
import com.jh.hotelbookingmanagement.entity.Branch;

@Mapper(componentModel = "spring")
public interface BranchMapper {
//    default Branch toBranchWithLogging(BranchCreationRequest request) {
//        System.out.println("Mapping Request: " + request);
//        Branch branch = toBranch(request);
//        System.out.println("Mapped Entity: " + branch);
//        return branch;
//    }

    Branch toBranch(BranchCreationRequest request);

    BranchResponse toBranchResponse(Branch branch);

    List<BranchResponse> toBranchResponse(List<Branch> branches);

    void updateBranch(@MappingTarget Branch branch, BranchUpdateRequest request);
}
