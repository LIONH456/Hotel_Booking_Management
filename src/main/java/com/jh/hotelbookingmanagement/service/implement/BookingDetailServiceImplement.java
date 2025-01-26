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
import com.jh.hotelbookingmanagement.service.implement.BookingService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.time.temporal.ChronoUnit;

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
    BookingService bookingService;

    @Override
    @Transactional
    public BookingDetailResponse createBookingDetail(String bookingId, BookingDetailRequest request) {
        // Validate dates
        if (request.getCheckInDate().isAfter(request.getCheckOutDate())) {
            throw new AppException(ErrorCode.INVALID_DATE_RANGE);
        }

        // Check room availability
        if (!isRoomAvailable(request.getRoomId(), request.getCheckInDate(), request.getCheckOutDate())) {
            throw new AppException(ErrorCode.ROOM_NOT_AVAILABLE);
        }

        BookingDetail bookingDetail = bookingDetailsMapper.toBookingDetail(request);

        // Set room and calculate charges
        var room = roomRepository.findById(request.getRoomId())
                .orElseThrow(() -> new AppException(ErrorCode.ROOM_NOT_FOUND));
        bookingDetail.setRoom(room);

        // Set booking
        bookingDetail.setBooking(bookingRepository.findById(bookingId)
                .orElseThrow(() -> new AppException(ErrorCode.BOOKING_NOT_FOUND)));

        // Calculate charges
        calculateCharges(bookingDetail);

        // Save booking detail
        bookingDetail = bookingDetailRepository.save(bookingDetail);

        // Update parent booking
        updateParentBooking(bookingDetail.getBooking().getBookingId());

        return bookingDetailsMapper.toBookingDetailResponse(bookingDetail);
    }

    private void calculateCharges(BookingDetail bookingDetail) {
        // Calculate room charge based on number of days
        long days = ChronoUnit.DAYS.between(
            bookingDetail.getCheckInDate(),
            bookingDetail.getCheckOutDate()
        );
        
        double roomCharge = bookingDetail.getRoom().getPrice() * days;
        bookingDetail.setTotalRoomCharge(roomCharge);
        
        // Initialize other charges if null
        bookingDetail.setItemCharge(bookingDetail.getItemCharge() != null ? 
            bookingDetail.getItemCharge() : 0.0);
        bookingDetail.setServiceCharge(bookingDetail.getServiceCharge() != null ? 
            bookingDetail.getServiceCharge() : 0.0);
        
        // Calculate total
        double totalAmount = roomCharge + 
            bookingDetail.getItemCharge() + 
            bookingDetail.getServiceCharge();
        bookingDetail.setTotalAmount(totalAmount);
    }

    private boolean isRoomAvailable(String roomId, LocalDateTime checkIn, LocalDateTime checkOut) {
        return bookingDetailRepository.findConflictingBookings(
            roomId, checkIn, checkOut).isEmpty();
    }

    private void updateParentBooking(String bookingId) {
        // Update room count and total amount in parent booking
        bookingDetailRepository.updateRoomCount(bookingId);
        bookingService.updateBookingTotalAmount(bookingId);
    }

    @Override
    public List<BookingDetailResponse> getBookingDetails() {
        return bookingDetailRepository.findAll().stream()
                .map(bookingDetailsMapper::toBookingDetailResponse)
                .toList();
    }

    @Override
    public BookingDetailResponse getBookingDetail(String bookingDetailId) {
        return bookingDetailsMapper.toBookingDetailResponse(
            bookingDetailRepository.findById(bookingDetailId)
                .orElseThrow(() -> new AppException(ErrorCode.BOOKING_DETAIL_NOT_FOUND))
        );
    }

    @Override
    public void deleteBookingDetail(String bookingDetailId) {
        if (!bookingDetailRepository.existsById(bookingDetailId)) {
            throw new AppException(ErrorCode.BOOKING_DETAIL_NOT_FOUND);
        }
        bookingDetailRepository.deleteById(bookingDetailId);
    }

    @Override
    public BookingDetailResponse updateBookingDetail(String bookingDetailId, BookingDetailUpdateRequest request) {
        BookingDetail bookingDetail = bookingDetailRepository.findById(bookingDetailId)
            .orElseThrow(() -> new AppException(ErrorCode.BOOKING_DETAIL_NOT_FOUND));

        bookingDetailsMapper.updateBookingDetail(bookingDetail, request);

        return bookingDetailsMapper.toBookingDetailResponse(bookingDetailRepository.save(bookingDetail));
    }
}
