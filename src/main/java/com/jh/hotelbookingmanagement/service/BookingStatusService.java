package com.jh.hotelbookingmanagement.service;


import com.jh.hotelbookingmanagement.dto.request.BookingStatusRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingStatusResponse;

import java.util.List;

public interface BookingStatusService {
    BookingStatusResponse createBookingStatus(BookingStatusRequest request);
    
    List<BookingStatusResponse> getAllBookingStatus();

    BookingStatusResponse updateBookingStatus(Long BookingStatusId, BookingStatusRequest request);

    void deleteBookingStatus(Long BookingStatusId);
    
}
