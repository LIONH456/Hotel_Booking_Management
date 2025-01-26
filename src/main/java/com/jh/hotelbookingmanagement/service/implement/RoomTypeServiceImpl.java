package com.jh.hotelbookingmanagement.service.implement;

import com.jh.hotelbookingmanagement.dto.request.RoomTypeRequest;
import com.jh.hotelbookingmanagement.dto.response.RoomTypeResponse;
import com.jh.hotelbookingmanagement.entity.RoomType;
import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import com.jh.hotelbookingmanagement.mapper.RoomTypeMapper;
import com.jh.hotelbookingmanagement.repository.RoomTypeRepository;
import com.jh.hotelbookingmanagement.service.RoomTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomTypeServiceImpl implements RoomTypeService {
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
    public RoomTypeResponse updateRoomType(Long roomTypeId, RoomTypeRequest request) {
        RoomType roomType = roomTypeRepository.findById(roomTypeId)
                .orElseThrow(() -> new AppException(ErrorCode.ROOM_TYPE_NOT_FOUND));

        roomTypeMapper.updateRoomType(roomType, request);
        roomType = roomTypeRepository.save(roomType);
        return roomTypeMapper.toRoomTypeResponse(roomType);
    }

    @Override
    public void deleteRoomType(Long roomTypeId) {
        if (!roomTypeRepository.existsById(roomTypeId)) {
            throw new AppException(ErrorCode.ROOM_TYPE_NOT_FOUND);
        }
        roomTypeRepository.deleteById(roomTypeId);
    }
}