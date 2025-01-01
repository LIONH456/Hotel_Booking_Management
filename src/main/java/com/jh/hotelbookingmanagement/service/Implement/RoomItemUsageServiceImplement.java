package com.jh.hotelbookingmanagement.service.Implement;

import com.jh.hotelbookingmanagement.dto.request.RoomItemUsageRequest;
import com.jh.hotelbookingmanagement.dto.response.RoomItemUsageResponse;
import com.jh.hotelbookingmanagement.entity.RoomItemUsage;
import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import com.jh.hotelbookingmanagement.mapper.RoomItemUsageMapper;
import com.jh.hotelbookingmanagement.repository.BookingDetailRepository;
import com.jh.hotelbookingmanagement.repository.RoomItemRepository;
import com.jh.hotelbookingmanagement.repository.RoomItemUsageRepository;
import com.jh.hotelbookingmanagement.service.RoomItemUsageService;
import jakarta.transaction.Transactional;
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
@Transactional
public class RoomItemUsageServiceImplement implements RoomItemUsageService {
    RoomItemUsageRepository roomItemUsageRepository;
    RoomItemUsageMapper roomItemUsageMapper;
    BookingDetailRepository bookingDetailRepository;
    RoomItemRepository roomItemRepository;

    @Override
    public RoomItemUsageResponse createRoomItemUsage(RoomItemUsageRequest request) {
        RoomItemUsage roomItemUsage = RoomItemUsage.builder()
                .quantity(request.getQuantity())
                .charge(request.getQuantity() * roomItemUsageRepository.getUnitPriceByItemId(request.getItemId()))
                .bookingDetail(bookingDetailRepository.findById(request.getBookingDetailId()).orElseThrow(() -> new AppException(ErrorCode.BOOKING_NOT_FOUND)))
                .item(roomItemRepository.findById(request.getItemId()).orElseThrow(() -> new AppException(ErrorCode.ROOM_ITEM_NOT_FOUND)))
                .build();

        // Check stock
        if (roomItemUsageRepository.getStockByItemId(request.getItemId()) < request.getQuantity()) {
            throw new AppException(ErrorCode.INSUFFICIENT_STOCK);
        }
        // Save to table before update other table...
        roomItemUsageRepository.save(roomItemUsage);

        // update stock and item charge in booking Detail
        roomItemUsageRepository.updateStock(roomItemUsage.getQuantity(), request.getItemId());
        roomItemUsageRepository.updateItemCharge(request.getBookingDetailId());

        return roomItemUsageMapper.toRoomItemUsageResponse(roomItemUsageRepository.save(roomItemUsage));
    }

    @Override
    public List<RoomItemUsageResponse> getAllRoomItemUsage() {
        return roomItemUsageRepository.findAll().stream()
                .map(roomItemUsageMapper::toRoomItemUsageResponse).toList();
    }

    @Override
    public RoomItemUsageResponse updateRoomItemUsage(String roomItemUsageId, RoomItemUsageRequest request) {
        RoomItemUsage roomItemUsage = roomItemUsageRepository.findById(roomItemUsageId)
                .orElseThrow(()->new AppException(ErrorCode.BOOKING_METHOD_NOT_FOUND));
        roomItemUsageMapper.updateRoomItemUsage(roomItemUsage, request);

        return roomItemUsageMapper.toRoomItemUsageResponse(roomItemUsageRepository.save(roomItemUsage));
    }

    @Override
    public void deleteRoomItemUsage(String roomItemUsageId) {
        roomItemUsageRepository.deleteById(roomItemUsageId);
    }
}
