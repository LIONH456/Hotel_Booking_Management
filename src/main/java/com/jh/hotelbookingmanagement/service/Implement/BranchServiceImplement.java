package com.jh.hotelbookingmanagement.service.Implement;

import java.util.List;
import java.util.stream.Collectors;

import com.jh.hotelbookingmanagement.dto.request.BranchUpdateRequest;
import com.jh.hotelbookingmanagement.dto.request.UserUpdateRequest;
import com.jh.hotelbookingmanagement.dto.response.RoomResponse;
import com.jh.hotelbookingmanagement.dto.response.UserResponse;
import com.jh.hotelbookingmanagement.entity.Room;
import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import org.springframework.stereotype.Service;

import com.jh.hotelbookingmanagement.dto.request.BranchCreationRequest;
import com.jh.hotelbookingmanagement.dto.response.BranchResponse;
import com.jh.hotelbookingmanagement.entity.Branch;
import com.jh.hotelbookingmanagement.mapper.BranchMapper;
import com.jh.hotelbookingmanagement.repository.BranchRepository;
import com.jh.hotelbookingmanagement.repository.RoomRepository;
import com.jh.hotelbookingmanagement.service.BranchService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BranchServiceImplement implements BranchService {
    BranchRepository branchRepository;
    RoomRepository roomRepository;
    BranchMapper branchMapper;

    // Create a new branch
    @Override
    public BranchResponse createBranch(BranchCreationRequest request) {
        Branch branch = branchMapper.toBranch(request);
        // Save the branch entity first to get the branch ID
        branch = branchRepository.save(branch);

        // Count the number of rooms associated with this branch
        int roomCount = roomRepository.countRoomsByBranchId(branch.getBranchId());
        branch.setNumberOfRooms(String.valueOf(roomCount)); // Update the number of rooms

        // Save the branch again with the updated room count
        branch = branchRepository.save(branch);

        return branchMapper.toBranchResponse(branch);
    }

    // // Find all branches and map them to BranchResponse objects, including their associated rooms.
    @Override
    public List<BranchResponse> getAllBranchInfo() {
        List<Branch> branches = branchRepository.findAll();

        return branches.stream().map(branch -> {
            BranchResponse branchResponse = branchMapper.toBranchResponse(branch);
            List<Room> rooms = roomRepository.findAllByBranchId(branch.getBranchId());
            branchResponse.setRooms(rooms.stream().map(RoomResponse::fromRoom).collect(Collectors.toList()));
            branchResponse.setRoomNumbers(rooms.stream().map(Room::getRoomNumber).collect(Collectors.toSet()));
            return branchResponse;
        }).toList();
    }

    // Get the information in each brand
    @Override
    public BranchResponse getBranchInfo(String branchId) {
        // Fetch the branch
        Branch currentBranch = branchRepository.findById(branchId)
                .orElseThrow(() -> new AppException(ErrorCode.BRANCH_NOT_FOUND));

        // Fetch associated rooms
        List<Room> rooms = roomRepository.findAllByBranchId(currentBranch.getBranchId());

        // Create BranchResponse and populate it with data
        BranchResponse branchResponse = branchMapper.toBranchResponse(currentBranch);
        branchResponse.setRooms(rooms.stream()
                .map(room -> {
                    RoomResponse roomResponse = new RoomResponse();
                    roomResponse.setRoomNumber(room.getRoomNumber());
                    return roomResponse;
                })
                .collect(Collectors.toList()));

        // Add roomNumbers to the response
        branchResponse.setRoomNumbers(rooms.stream().map(Room::getRoomNumber).collect(Collectors.toSet()));

        return branchResponse;
    }

    @Override
    public BranchResponse updateBranch(String branchId, BranchUpdateRequest request) {
        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new AppException(ErrorCode.BRANCH_NOT_FOUND));

        branchMapper.updateBranch(branch, request);

        return branchMapper.toBranchResponse(branchRepository.save(branch));
    }

    @Override
    public void deleteBranch(String branchId){
        branchRepository.deleteById(branchId);
    }
}
