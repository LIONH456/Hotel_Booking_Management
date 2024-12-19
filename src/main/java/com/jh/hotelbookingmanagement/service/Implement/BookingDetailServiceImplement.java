package com.jh.hotelbookingmanagement.service.Implement;

import com.jh.hotelbookingmanagement.dto.request.BookingDetailRequest;
import com.jh.hotelbookingmanagement.dto.request.BookingDetailUpdateRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingDetailResponse;
import com.jh.hotelbookingmanagement.dto.response.RoomResponse;
import com.jh.hotelbookingmanagement.entity.Booking;
import com.jh.hotelbookingmanagement.entity.BookingDetail;
import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import com.jh.hotelbookingmanagement.mapper.BookingDetailsMapper;
import com.jh.hotelbookingmanagement.repository.BookingDetailRepository;
import com.jh.hotelbookingmanagement.repository.BookingRepository;
import com.jh.hotelbookingmanagement.repository.RoomRepository;
import com.jh.hotelbookingmanagement.repository.UserRepository;
import com.jh.hotelbookingmanagement.service.BookingDetailService;
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
public class BookingDetailServiceImplement implements BookingDetailService {
    BookingDetailRepository bookingDetailRepository;
    BookingDetailsMapper bookingDetailsMapper;
    RoomRepository roomRepository;
    BookingRepository bookingRepository;

    @Override
    public BookingDetailResponse createBookingDetail(BookingDetailRequest request) {
        BookingDetail bookingDetail = bookingDetailsMapper.toBookingDetail(request);

        bookingDetail.setRoom(roomRepository.findById(request.getRoomId()).orElseThrow(()-> new AppException(ErrorCode.ROOM_NOT_FOUND)));

        bookingDetail.setBooking(bookingRepository.findById(request.getBookingId()).orElseThrow(()-> new AppException(ErrorCode.BOOKING_NOT_FOUND)));

        bookingDetail = bookingDetailRepository.save(bookingDetail);
        log.info("After: "+ bookingDetail.getBooking().getBookingId());
        return bookingDetailsMapper.toBookingDetailResponse(bookingDetail);
    }

    @Override
    public List<BookingDetailResponse> getBookingDetails() {
        return bookingDetailRepository.findAll().stream()
                .map(bookingDetailsMapper::toBookingDetailResponse)
                .toList();
    }

    @Override
    public BookingDetailResponse getBookingDetail(String bookingDetailId) {
        return bookingDetailsMapper.toBookingDetailResponse(bookingDetailRepository.findById(bookingDetailId).orElseThrow(()->new AppException(ErrorCode.BOOKING_NOT_FOUND)));
    }

    @Override
    public void deleteBookingDetail(String bookingDetailId) {
        bookingDetailRepository.deleteById(bookingDetailId);
    }

    @Override
    public BookingDetailResponse updateBookingDetail(String bookingDetailId, BookingDetailUpdateRequest request) {
        BookingDetail bookingDetail = bookingDetailRepository.findById(bookingDetailId).orElseThrow(() -> new AppException(ErrorCode.BOOKING_NOT_FOUND));

        bookingDetailsMapper.updateBookingDetail(bookingDetail, request);

        return bookingDetailsMapper.toBookingDetailResponse(bookingDetailRepository.save(bookingDetail));
    }
}
