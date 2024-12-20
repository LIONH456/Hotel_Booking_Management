package com.jh.hotelbookingmanagement.service.Implement;

import com.jh.hotelbookingmanagement.dto.request.BookingMethodRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingMethodResponse;
import com.jh.hotelbookingmanagement.entity.Booking;
import com.jh.hotelbookingmanagement.entity.BookingMethod;
import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import com.jh.hotelbookingmanagement.mapper.BookingMethodMapper;
import com.jh.hotelbookingmanagement.repository.BookingMethodRepository;
import com.jh.hotelbookingmanagement.service.BookingMethodService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class BookingMethodServiceImplement implements BookingMethodService {
    BookingMethodRepository bookingMethodRepository;
    BookingMethodMapper bookingMethodMapper;

    @Override
    public BookingMethodResponse createBookingMethod(BookingMethodRequest request) {
        BookingMethod bookingMethod = bookingMethodMapper.toBookingMethod(request);

        bookingMethod = bookingMethodRepository.save(bookingMethod);
        return bookingMethodMapper.toBookingMethodResponse(bookingMethod);
    }

    @Override
    public List<BookingMethodResponse> getAllBookingMethod() {
        return bookingMethodRepository.findAll().stream()
                .map(bookingMethodMapper::toBookingMethodResponse).toList();
    }

    @Override
    public BookingMethodResponse updateBookingMethod(Long bookingMethodId, BookingMethodRequest request) {
        BookingMethod bookingMethod = bookingMethodRepository.findById(bookingMethodId)
                .orElseThrow(()->new AppException(ErrorCode.BOOKING_METHOD_NOT_FOUND));
        bookingMethodMapper.updateBookingMethod(bookingMethod, request);
        return bookingMethodMapper.toBookingMethodResponse(bookingMethodRepository.save(bookingMethod));
    }

    @Override
    public void deleteBookingMethod(Long bookingMethodId) {
        bookingMethodRepository.deleteById(bookingMethodId);
    }
}
