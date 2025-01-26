package com.jh.hotelbookingmanagement.service;

import com.jh.hotelbookingmanagement.dto.request.BookingDetailRequest;
import com.jh.hotelbookingmanagement.dto.request.BookingDetailUpdateRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingDetailResponse;
import com.jh.hotelbookingmanagement.entity.BookingDetail;

import java.util.List;

public interface BookingDetailService {
    public BookingDetailResponse createBookingDetail(String bookingId, BookingDetailRequest request);

    public List<BookingDetailResponse> getBookingDetails();

    public BookingDetailResponse getBookingDetail(String bookingDetailId);

    public BookingDetailResponse updateBookingDetail(String bookingDetailId, BookingDetailUpdateRequest request);

    public void deleteBookingDetail(String bookingDetailId);
}
