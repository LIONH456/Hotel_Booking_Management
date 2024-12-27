package com.jh.hotelbookingmanagement.service.Implement;

import com.jh.hotelbookingmanagement.dto.request.RoomItemRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingDetailResponse;
import com.jh.hotelbookingmanagement.dto.response.RoomItemResponse;
import com.jh.hotelbookingmanagement.entity.RoomItem;
import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import com.jh.hotelbookingmanagement.mapper.RoomItemMapper;
import com.jh.hotelbookingmanagement.repository.RoomItemRepository;
import com.jh.hotelbookingmanagement.service.RoomItemService;
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
public class RoomItemServiceImplement implements RoomItemService {
    RoomItemRepository roomItemRepository;
    RoomItemMapper roomItemMapper;

    @Override
    public RoomItemResponse createRoomItem(RoomItemRequest request) {
        RoomItem roomItem = roomItemMapper.toRoomItem(request);

        roomItem = roomItemRepository.save(roomItem);
        return roomItemMapper.toRoomItemResponse(roomItem);
    }

    @Override
    public List<RoomItemResponse> getAllRoomItem() {
        return roomItemRepository.findAll().stream()
                .map(roomItemMapper::toRoomItemResponse).toList();
    }

    @Override
    public RoomItemResponse updateRoomItem(Long roomItemId, RoomItemRequest request) {
        RoomItem roomItem = roomItemRepository.findById(roomItemId)
                .orElseThrow(()->new AppException(ErrorCode.ROOM_ITEM_NOT_FOUND));
        roomItemMapper.updateRoomItem(roomItem, request);
        return roomItemMapper.toRoomItemResponse(roomItemRepository.save(roomItem));
    }

    @Override
    public void deleteRoomItem(Long roomItemId) {
        roomItemRepository.deleteById(roomItemId);
    }

    @Override
    public RoomItemResponse getRoomItem(Long roomItemId) {
        return roomItemMapper.toRoomItemResponse(roomItemRepository.findById(roomItemId).orElseThrow(()->new AppException(ErrorCode.ROOM_ITEM_NOT_FOUND)));
    }
}
