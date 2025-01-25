package com.jh.hotelbookingmanagement.service.implement;

import java.util.List;
import java.util.stream.Collectors;

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
        booking.setBookedBy(userRepository.findById(request.getBookedBy()).orElseThrow(()->new AppException(ErrorCode.USER_NOT_EXISTED)));
        booking.setBookingMethod(bookingMethodRepository.findById(request.getBookingMethodId()).orElseThrow(()->new AppException(ErrorCode.BOOKING_METHOD_NOT_FOUND)));
        booking.setRoomCount(0);
        booking.setBookingDetails(bookingDetailRepository.findAllByBooking_BookingId(booking.getBookingId()));
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

    @Service
    @RequiredArgsConstructor
    public static class RoomTypeServiceImpl implements RoomTypeService {
        private final RoomTypeRepository roomTypeRepository;
        private final RoomTypeMapper roomTypeMapper;

        @Override
        public RoomTypeResponse createRoomType(RoomTypeRequest request) {
            RoomType roomType = roomTypeMapper.toRoomType(request);
            roomType = roomTypeRepository.save(roomType);
            return roomTypeMapper.toRoomTypeResponse(roomType);
        }

        @Override
        public List<RoomTypeResponse> getAllRoomType() {
            return roomTypeRepository.findAll()
                    .stream()
                    .map(roomTypeMapper::toRoomTypeResponse)
                    .collect(Collectors.toList());
        }

        @Override
        public RoomTypeResponse updateRoomType(String roomTypeId, RoomTypeRequest request) {
            RoomType roomType = roomTypeRepository.findById(roomTypeId)
                    .orElseThrow(() -> new AppException(ErrorCode.ROOM_TYPE_NOT_FOUND));

            roomTypeMapper.updateRoomType(roomType, request);
            roomType = roomTypeRepository.save(roomType);
            return roomTypeMapper.toRoomTypeResponse(roomType);
        }

        @Override
        public void deleteRoomType(String roomTypeId) {
            if (!roomTypeRepository.existsById(roomTypeId)) {
                throw new AppException(ErrorCode.ROOM_TYPE_NOT_FOUND);
            }
            roomTypeRepository.deleteById(roomTypeId);
        }
    }
}
