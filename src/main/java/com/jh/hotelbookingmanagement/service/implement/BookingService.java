package com.jh.hotelbookingmanagement.service.implement;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

import com.jh.hotelbookingmanagement.dto.request.BookingDetailRequest;
import com.jh.hotelbookingmanagement.dto.request.RoomTypeRequest;
import com.jh.hotelbookingmanagement.dto.response.RoomResponse;
import com.jh.hotelbookingmanagement.dto.response.RoomTypeResponse;
import com.jh.hotelbookingmanagement.entity.Room;
import com.jh.hotelbookingmanagement.entity.RoomType;
import com.jh.hotelbookingmanagement.mapper.RoomMapper;
import com.jh.hotelbookingmanagement.mapper.RoomTypeMapper;
import com.jh.hotelbookingmanagement.repository.*;
import com.jh.hotelbookingmanagement.service.RoomTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jh.hotelbookingmanagement.dto.request.BookingCreationRequest;
import com.jh.hotelbookingmanagement.dto.request.BookingUpdateRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingResponse;
import com.jh.hotelbookingmanagement.entity.Booking;
import com.jh.hotelbookingmanagement.entity.BookingDetail;
import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import com.jh.hotelbookingmanagement.mapper.BookingMapper;
import com.jh.hotelbookingmanagement.mapper.BookingDetailsMapper;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final BookingDetailRepository bookingDetailRepository;
    private final BookingMapper bookingMapper;
    private final BookingDetailsMapper bookingDetailsMapper;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;
    private final BookingMethodRepository bookingMethodRepository;
    private final RoomMapper roomMapper;
    private final BookingStatusRepository bookingStatusRepository;

    @Transactional
    public BookingResponse createBooking(BookingCreationRequest request) {
        // Create booking
        Booking booking = Booking.builder()
            .bookingMethod(bookingMethodRepository.findById(request.getBookingMethodId())
                .orElseThrow(() -> new AppException(ErrorCode.BOOKING_METHOD_NOT_FOUND)))
            .bookedBy(userRepository.findById(request.getBookedBy())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)))
            .bookedDate(LocalDateTime.now())
            .build();
        
        booking = bookingRepository.save(booking);
        
        // Create booking details
        if (request.getBookingDetails() != null) {
            for (BookingDetailRequest detailRequest : request.getBookingDetails()) {
                BookingDetail detail = BookingDetail.builder()
                    .booking(booking)
                    .room(roomRepository.findById(detailRequest.getRoomId())
                        .orElseThrow(() -> new AppException(ErrorCode.ROOM_NOT_FOUND)))
                    .checkInDate(detailRequest.getCheckInDate())
                    .checkOutDate(detailRequest.getCheckOutDate())
                    .adult(detailRequest.getAdult())
                    .child(detailRequest.getChild())
                    .bookingStatus(bookingStatusRepository.findById(1L)  // Default status (e.g., "Pending")
                        .orElseThrow(() -> new AppException(ErrorCode.BOOKING_STATUS_NOT_FOUND)))
                    .build();
                
                bookingDetailRepository.save(detail);
            }
        }
        
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

    public List<RoomResponse> getAvailableRoomsByBranch(String branchId, LocalDateTime checkIn, LocalDateTime checkOut) {
        // Get all rooms in branch
        List<Room> branchRooms = roomRepository.findAllByBranch_BranchId(branchId);
        
        // Filter out booked rooms for the given period
        return branchRooms.stream()
            .filter(room -> isRoomAvailable(room.getRoomId(), checkIn, checkOut))
            .map(roomMapper::toRoomRespone)
            .collect(Collectors.toList());
    }

    private boolean isRoomAvailable(String roomId, LocalDateTime checkIn, LocalDateTime checkOut) {
        return bookingDetailRepository.findConflictingBookings(roomId, checkIn, checkOut).isEmpty();
    }

}
