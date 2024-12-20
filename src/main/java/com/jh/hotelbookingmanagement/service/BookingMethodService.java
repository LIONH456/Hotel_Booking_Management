package com.jh.hotelbookingmanagement.service;


import com.jh.hotelbookingmanagement.dto.request.BookingMethodRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingMethodResponse;

import java.util.List;

public interface BookingMethodService {
    BookingMethodResponse createBookingMethod(BookingMethodRequest request);
    
    List<BookingMethodResponse> getAllBookingMethod();

    BookingMethodResponse updateBookingMethod(Long BookingMethodId, BookingMethodRequest request);

    void deleteBookingMethod(Long BookingMethodId);
    
}
