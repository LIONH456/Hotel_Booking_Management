package com.jh.hotelbookingmanagement.controller;

import com.jh.hotelbookingmanagement.dto.request.ApiResponse;
import com.jh.hotelbookingmanagement.dto.request.ProvidedServicesRequest;
import com.jh.hotelbookingmanagement.dto.response.ProvidedServicesResponse;
import com.jh.hotelbookingmanagement.service.ProvidedServicesService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/providedServices")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProvidedServicesController {
    ProvidedServicesService providedServicesService;

    @PostMapping
    ApiResponse<ProvidedServicesResponse> createBooking(@RequestBody ProvidedServicesRequest request) {
        return ApiResponse.<ProvidedServicesResponse>builder()
                .result(providedServicesService.createProvidedServices(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<ProvidedServicesResponse>> getBookings() {
        return ApiResponse.<List<ProvidedServicesResponse>>builder()
                .result(providedServicesService.getAllProvidedServices())
                .build();
    }

    @PutMapping("/{providedServicesId}")
    ProvidedServicesResponse updateProvidedServices(@PathVariable Long providedServicesId, @RequestBody ProvidedServicesRequest request) {
        return providedServicesService.updateProvidedServices(providedServicesId, request);
    }
//
    @DeleteMapping("/{providedServicesId}")
    ApiResponse<String> deleteProvidedServices(@PathVariable Long providedServicesId) {
        providedServicesService.deleteProvidedServices(providedServicesId);
        return ApiResponse.<String>builder().result("This service has been Deleted!").build();
    }

    @GetMapping("/{providedServicesId}")
    ApiResponse<ProvidedServicesResponse> getBooking(@PathVariable("providedServicesId") Long providedServicesId) {
        return ApiResponse.<ProvidedServicesResponse>builder()
                .result(providedServicesService.getProvidedServices(providedServicesId))
                .build();
    }
}
