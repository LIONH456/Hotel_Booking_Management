package com.jh.hotelbookingmanagement.service;

import com.jh.hotelbookingmanagement.dto.request.BookingDetailRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingDetailResponse;
import com.jh.hotelbookingmanagement.entity.BookingDetail;

import java.util.List;

public interface BookingDetailService {
    public BookingDetailResponse createBookingDetail(BookingDetailRequest request);

    public List<BookingDetailResponse> getBookingDetails();

    public BookingDetail getBookingDetail(String branchId);

    public BookingDetail updateBookingDetail(String brandId, BookingDetailRequest request);

    public void deleteBookingDetail(String bookingDetailId);
}
