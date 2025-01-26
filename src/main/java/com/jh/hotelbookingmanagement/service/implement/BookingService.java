package com.jh.hotelbookingmanagement.service.implement;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

import com.jh.hotelbookingmanagement.dto.request.RoomTypeRequest;
import com.jh.hotelbookingmanagement.dto.response.RoomTypeResponse;
import com.jh.hotelbookingmanagement.entity.RoomType;
import com.jh.hotelbookingmanagement.mapper.RoomTypeMapper;
import com.jh.hotelbookingmanagement.repository.*;
import com.jh.hotelbookingmanagement.service.RoomTypeService;
import org.springframework.stereotype.Service;

import com.jh.hotelbookingmanagement.dto.request.BookingCreationRequest;
import com.jh.hotelbookingmanagement.dto.request.BookingUpdateRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingResponse;
import com.jh.hotelbookingmanagement.entity.Booking;
import com.jh.hotelbookingmanagement.entity.BookingDetail;
import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import com.jh.hotelbookingmanagement.mapper.BookingMapper;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class BookingService {
    private final BookingDetailRepository bookingDetailRepository;
    private final RoomRepository roomRepository;

    BookingRepository bookingRepository;

    BookingMapper bookingMapper;

    UserRepository userRepository;

    BookingMethodRepository bookingMethodRepository;

    public BookingResponse createRequest(BookingCreationRequest request) {
        Booking booking = bookingMapper.toBooking(request);
        
        // Validate user and booking method
        booking.setBookedBy(userRepository.findById(request.getBookedBy())
            .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));
        booking.setBookingMethod(bookingMethodRepository.findById(request.getBookingMethodId())
            .orElseThrow(() -> new AppException(ErrorCode.BOOKING_METHOD_NOT_FOUND)));
        
        // Initialize booking
        booking.setRoomCount(0);
        booking.setTotalAmount(0.0);  // Initialize total amount
        booking.setActive(true);      // Set initial active status
        booking.setBookedDate(LocalDateTime.now());  // Set current timestamp
        
        // Save and return
        booking = bookingRepository.save(booking);
        return bookingMapper.toBookingResponse(booking);
    }

    public List<BookingResponse> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(bookingMapper::toBookingResponse)
                .toList();
    }

    public BookingResponse getBooking(String bookingId) {
        return bookingMapper.toBookingResponse(
                bookingRepository.findById(bookingId).orElseThrow(() -> new AppException(ErrorCode.BOOKING_NOT_FOUND)));
    }

    public BookingResponse updateBooking(String bookingId, BookingUpdateRequest request) {
        Booking booking =
                bookingRepository.findById(bookingId).orElseThrow(() -> new AppException(ErrorCode.BOOKING_NOT_FOUND));
        bookingMapper.updateBooking(booking, request);

        return bookingMapper.toBookingResponse(bookingRepository.save(booking));
    }

    public void deleteBooking(String bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    public List<Booking> getBookingsByUser(String userId) {
        return bookingRepository.findByBookedByUserId(userId);
    }

    // Add method to update booking total amount
    public void updateBookingTotalAmount(String bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
            .orElseThrow(() -> new AppException(ErrorCode.BOOKING_NOT_FOUND));
            
        Double totalAmount = booking.getBookingDetails().stream()
            .mapToDouble(BookingDetail::getTotalAmount)
            .sum();
            
        booking.setTotalAmount(totalAmount);
        bookingRepository.save(booking);
    }


}
