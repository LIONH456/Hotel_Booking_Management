package com.jh.hotelbookingmanagement.service;

import java.util.List;

import com.jh.hotelbookingmanagement.dto.request.BranchCreationRequest;
import com.jh.hotelbookingmanagement.dto.request.BranchUpdateRequest;
import com.jh.hotelbookingmanagement.dto.response.BranchResponse;
import com.jh.hotelbookingmanagement.dto.response.UserResponse;

public interface BranchService {
    public BranchResponse createBranch(BranchCreationRequest request);

    public List<BranchResponse> getAllBranchInfo();

    public BranchResponse getBranchInfo(String branchId);

    public BranchResponse updateBranch(String branchId, BranchUpdateRequest request);

    public void deleteBranch(String branchId);
}
