package com.jh.hotelbookingmanagement.service.implement;

import com.jh.hotelbookingmanagement.dto.request.BookingStatusRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingStatusResponse;
import com.jh.hotelbookingmanagement.entity.BookingStatus;
import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import com.jh.hotelbookingmanagement.mapper.BookingStatusMapper;
import com.jh.hotelbookingmanagement.repository.BookingStatusRepository;
import com.jh.hotelbookingmanagement.service.BookingStatusService;
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
public class BookingStatusServiceImplement implements BookingStatusService {
    BookingStatusRepository bookingStatusRepository;
    BookingStatusMapper bookingStatusMapper;

    @Override
    public BookingStatusResponse createBookingStatus(BookingStatusRequest request) {
        log.info("Creating booking status with name: {}", request.getBookingStatusName());
        BookingStatus bookingStatus = bookingStatusMapper.toBookingStatus(request);
        bookingStatus = bookingStatusRepository.save(bookingStatus);
        return bookingStatusMapper.toBookingStatusResponse(bookingStatus);
    }

    @Override
    public List<BookingStatusResponse> getAllBookingStatus() {
        log.info("Fetching all booking statuses");
        List<BookingStatus> statuses = bookingStatusRepository.findAll();
        log.info("Found {} booking statuses", statuses.size());
        return statuses.stream()
                .map(bookingStatusMapper::toBookingStatusResponse)
                .toList();
    }

    @Override
    public BookingStatusResponse updateBookingStatus(Long bookingStatusId, BookingStatusRequest request) {
        log.info("Updating booking status with id: {}", bookingStatusId);
        BookingStatus bookingStatus = bookingStatusRepository.findById(bookingStatusId)
                .orElseThrow(() -> new AppException(ErrorCode.BOOKING_STATUS_NOT_FOUND));
        
        bookingStatusMapper.updateBookingStatus(bookingStatus, request);
        bookingStatus = bookingStatusRepository.save(bookingStatus);
        return bookingStatusMapper.toBookingStatusResponse(bookingStatus);
    }

    @Override
    public void deleteBookingStatus(Long bookingStatusId) {
        log.info("Deleting booking status with id: {}", bookingStatusId);
        if (!bookingStatusRepository.existsById(bookingStatusId)) {
            throw new AppException(ErrorCode.BOOKING_STATUS_NOT_FOUND);
        }
        bookingStatusRepository.deleteById(bookingStatusId);
    }
}
