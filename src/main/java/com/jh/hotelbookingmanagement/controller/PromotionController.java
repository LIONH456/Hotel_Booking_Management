package com.jh.hotelbookingmanagement.controller;

import com.jh.hotelbookingmanagement.dto.request.ApiResponse;
import com.jh.hotelbookingmanagement.dto.request.PromotionRequest;
import com.jh.hotelbookingmanagement.dto.response.PromotionResponse;
import com.jh.hotelbookingmanagement.service.PromotionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/promotion")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PromotionController {
    PromotionService promotionService;

    @PostMapping
    ApiResponse<PromotionResponse> createBooking(@RequestBody PromotionRequest request) {
        return ApiResponse.<PromotionResponse>builder()
                .result(promotionService.createPromotion(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<PromotionResponse>> getBookings() {
        return ApiResponse.<List<PromotionResponse>>builder()
                .result(promotionService.getAllPromotion())
                .build();
    }
//
//    @GetMapping("/{bookingId}")
//    BookingResponse getBooking(@PathVariable("bookingId") String bookingId) {
//        return bookingService.getBooking(bookingId);
//    }

    @PutMapping("/{promotionId}")
    PromotionResponse updatePromotion(@PathVariable Long promotionId, @RequestBody PromotionRequest request) {
        return promotionService.updatePromotion(promotionId, request);
    }
//
    @DeleteMapping("/{promotionId}")
    ApiResponse<String> deletePromotion(@PathVariable Long promotionId) {
        promotionService.deletePromotion(promotionId);
        return ApiResponse.<String>builder().result("This promotion has been Deleted!").build();
    }
//
//    @GetMapping("/usersId:a{userId}")
//    List<Booking> getBookingsByUser(@PathVariable String userId) {
//        return bookingService.getBookingsByUser(userId);
//    }
}
