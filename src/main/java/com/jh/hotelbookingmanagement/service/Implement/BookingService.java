package com.jh.hotelbookingmanagement.service.Implement;

import java.util.List;

import com.jh.hotelbookingmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import com.jh.hotelbookingmanagement.dto.request.BookingCreationRequest;
import com.jh.hotelbookingmanagement.dto.request.BookingUpdateRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingResponse;
import com.jh.hotelbookingmanagement.entity.Booking;
import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import com.jh.hotelbookingmanagement.mapper.BookingMapper;
import com.jh.hotelbookingmanagement.repository.BookingRepository;
import com.jh.hotelbookingmanagement.repository.RoomRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class BookingService {
    private final RoomRepository roomRepository;

    BookingRepository bookingRepository;

    BookingMapper bookingMapper;

    UserRepository userRepository;

    public BookingResponse createRequest(BookingCreationRequest request) {

        Booking booking = bookingMapper.toBooking(request);
        booking.setBookedBy(userRepository.findById(request.getBookedBy()).orElseThrow(()->new AppException(ErrorCode.USER_NOT_EXISTED)));
        log.info(booking.getBookedBy() + "");
//        List<String> bookingStatuses = bookingRepository.isActive(booking.getBookingId());
//        booking.setActive(true);
//        log.info("this works");
//        for(String bookingStatus:bookingStatuses) {
//            log.info("Loop Work");
//            if (bookingStatus == "1") {
//                booking.setActive(false);
//                log.info(bookingStatus);
//            }
//        }
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
}
