package com.jh.hotelbookingmanagement.controller;

import com.jh.hotelbookingmanagement.dto.request.BranchUpdateRequest;
import org.springframework.web.bind.annotation.*;

import com.jh.hotelbookingmanagement.dto.request.ApiResponse;
import com.jh.hotelbookingmanagement.dto.request.BranchCreationRequest;
import com.jh.hotelbookingmanagement.dto.response.BranchResponse;
import com.jh.hotelbookingmanagement.service.BranchService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/branches")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BranchController {
    BranchService branchService;

    @PostMapping
    public ApiResponse<BranchResponse> createBranch(@RequestBody BranchCreationRequest request) {
//        log.info("BranchCreationRequest received: {}", request);
        return ApiResponse.<BranchResponse>builder().result(branchService.createBranch(request)).build();
    }

    @GetMapping
    public ApiResponse<List<BranchResponse>> getAllBranchInfo(){
        return ApiResponse.<List<BranchResponse>>builder().result(branchService.getAllBranchInfo()).build();
    }

    @GetMapping("/{branchId}")
    public  ApiResponse<BranchResponse> getBranchInfo(@PathVariable String branchId){
        return ApiResponse.<BranchResponse>builder().result(branchService.getBranchInfo(branchId)).build();
    }

    @PutMapping("/{branchId}")
    public ApiResponse<BranchResponse> updateBranch(@PathVariable String branchId, @RequestBody BranchUpdateRequest request){
        return ApiResponse.<BranchResponse>builder().result(branchService.updateBranch(branchId, request)).build();
    }

    @DeleteMapping("/{branchId}")
    ApiResponse<String> deleteBranch(@PathVariable String branchId){
        branchService.deleteBranch(branchId);
        return ApiResponse.<String>builder().result("Branch Has been Deleted").build();
    }
}
