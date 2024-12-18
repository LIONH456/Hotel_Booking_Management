package com.jh.hotelbookingmanagement.service.Implement;

import com.jh.hotelbookingmanagement.dto.request.BookingDetailRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingDetailResponse;
import com.jh.hotelbookingmanagement.entity.Booking;
import com.jh.hotelbookingmanagement.entity.BookingDetail;
import com.jh.hotelbookingmanagement.mapper.BookingDetailsMapper;
import com.jh.hotelbookingmanagement.repository.BookingDetailRepository;
import com.jh.hotelbookingmanagement.service.BookingDetailService;


import java.util.List;

public class BookingDetailServiceImplement implements BookingDetailService {
    BookingDetailRepository bookingDetailRepository;
    BookingDetailsMapper bookingDetailsMapper;

    @Override
    public BookingDetailResponse createBookingDetail(BookingDetailRequest request) {
        BookingDetail bookingDetail = bookingDetailsMapper.toBookingDetail(request);

        bookingDetail = bookingDetailRepository.save(bookingDetail);
        return bookingDetailsMapper.toBookingDetailResponse(bookingDetail);
    }

    @Override
    public List<BookingDetailResponse> getBookingDetails() {
        return List.of();
    }

    @Override
    public BookingDetail getBookingDetail(String branchId) {
        return null;
    }

    @Override
    public BookingDetail updateBookingDetail(String brandId, BookingDetailRequest request) {
        return null;
    }

    @Override
    public void deleteBookingDetail(String bookingDetailId) {

    }
}
