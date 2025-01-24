package com.jh.hotelbookingmanagement.service.implement;

import com.jh.hotelbookingmanagement.dto.request.BookingDetailRequest;
import com.jh.hotelbookingmanagement.dto.request.BookingDetailUpdateRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingDetailResponse;
import com.jh.hotelbookingmanagement.entity.BookingDetail;
import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import com.jh.hotelbookingmanagement.mapper.BookingDetailsMapper;
import com.jh.hotelbookingmanagement.repository.BookingDetailRepository;
import com.jh.hotelbookingmanagement.repository.BookingRepository;
import com.jh.hotelbookingmanagement.repository.RoomRepository;
import com.jh.hotelbookingmanagement.service.BookingDetailService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Transactional
public class BookingDetailServiceImplement implements BookingDetailService {
    BookingDetailRepository bookingDetailRepository;
    BookingDetailsMapper bookingDetailsMapper;
    RoomRepository roomRepository;
    BookingRepository bookingRepository;

    public BookingDetailResponse createBookingDetail(BookingDetailRequest request) {
        BookingDetail bookingDetail = bookingDetailsMapper.toBookingDetail(request);

        // Fetch room details
        var room = roomRepository.findById(request.getRoomId())
                .orElseThrow(() -> new AppException(ErrorCode.ROOM_NOT_FOUND));
        bookingDetail.setRoom(room);

        // Fetch booking details
        bookingDetail.setBooking(bookingRepository.findById(request.getBookingId())
                .orElseThrow(() -> new AppException(ErrorCode.BOOKING_NOT_FOUND)));

        // Calculate the number of days stayed
        LocalDate checkIn = request.getCheckInDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate checkOut = request.getCheckOutDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long numberOfDays = Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay()).toDays();

        if (numberOfDays <= 0) {
            throw new AppException(ErrorCode.INVALID_DATE_RANGE);
        }

        // Calculate room charge
        double roomCharge = room.getPrice() * numberOfDays;
        bookingDetail.setRoomCharge(roomCharge);

        // Set initial values for item charge and service charge if not provided
        bookingDetail.setItemCharge(0);
        bookingDetail.setServiceCharge(0);

        // Calculate total amount
        double totalAmount = roomCharge + bookingDetail.getItemCharge() + bookingDetail.getServiceCharge();
        bookingDetail.setTotalAmount(totalAmount);

        // Save booking detail
        bookingDetail = bookingDetailRepository.save(bookingDetail);

        log.info("Booking detail created: {}", bookingDetail);
        bookingDetailRepository.updateRoomCount(request.getBookingId());

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
