package com.jh.hotelbookingmanagement.service.implement;

import com.jh.hotelbookingmanagement.dto.request.RoomStatusRequest;
import com.jh.hotelbookingmanagement.dto.response.RoomStatusResponse;
import com.jh.hotelbookingmanagement.entity.RoomStatus;
import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import com.jh.hotelbookingmanagement.mapper.RoomStatusMapper;
import com.jh.hotelbookingmanagement.repository.RoomStatusRepository;
import com.jh.hotelbookingmanagement.service.RoomStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomStatusServiceImpl implements RoomStatusService {
    private final RoomStatusRepository roomStatusRepository;
    private final RoomStatusMapper roomStatusMapper;

    @Override
    public RoomStatusResponse createRoomStatus(RoomStatusRequest request) {
        RoomStatus roomStatus = roomStatusMapper.toRoomStatus(request);
        roomStatus = roomStatusRepository.save(roomStatus);
        return roomStatusMapper.toRoomStatusResponse(roomStatus);
    }

    @Override
    public List<RoomStatusResponse> getAllRoomStatus() {
        return roomStatusRepository.findAll()
                .stream()
                .map(roomStatusMapper::toRoomStatusResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RoomStatusResponse updateRoomStatus(Long statusId, RoomStatusRequest request) {
        RoomStatus roomStatus = roomStatusRepository.findById(statusId)
                .orElseThrow(() -> new AppException(ErrorCode.ROOM_STATUS_NOT_FOUND));

        roomStatusMapper.updateRoomStatus(roomStatus, request);
        roomStatus = roomStatusRepository.save(roomStatus);
        return roomStatusMapper.toRoomStatusResponse(roomStatus);
    }

    @Override
    public void deleteRoomStatus(Long statusId) {
        if (!roomStatusRepository.existsById(statusId)) {
            throw new AppException(ErrorCode.ROOM_STATUS_NOT_FOUND);
        }
        roomStatusRepository.deleteById(statusId);
    }

    @Override
    public RoomStatusResponse getRoomStatusById(Long statusId) {
        RoomStatus roomStatus = roomStatusRepository.findById(statusId)
                .orElseThrow(() -> new AppException(ErrorCode.ROOM_STATUS_NOT_FOUND));
        return roomStatusMapper.toRoomStatusResponse(roomStatus);
    }
} 