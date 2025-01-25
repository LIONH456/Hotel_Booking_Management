package com.jh.hotelbookingmanagement.service.implement;

import java.util.List;

import com.jh.hotelbookingmanagement.repository.BranchRepository;
import com.jh.hotelbookingmanagement.repository.RoomStatusRepository;
import com.jh.hotelbookingmanagement.repository.RoomTypeRepository;
import org.springframework.stereotype.Service;

import com.jh.hotelbookingmanagement.dto.request.RoomCreationRequest;
import com.jh.hotelbookingmanagement.dto.request.RoomUpdateRequest;
import com.jh.hotelbookingmanagement.dto.response.RoomResponse;
import com.jh.hotelbookingmanagement.entity.Room;
import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import com.jh.hotelbookingmanagement.mapper.RoomMapper;
import com.jh.hotelbookingmanagement.repository.RoomRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;
    private final BranchRepository branchRepository;
    private final RoomStatusRepository roomStatusRepository;
    private final RoomTypeRepository roomTypeRepository;

    public RoomResponse createRoom(RoomCreationRequest request) {
        Room room = roomMapper.toRoom(request);
        
        // Set branch
        room.setBranch(branchRepository.findById(request.getBranchId())
            .orElseThrow(() -> new AppException(ErrorCode.BRANCH_NOT_FOUND)));
        
        // Set room status
        room.setRoomStatusId(roomStatusRepository.findById(request.getRoomStatusId())
            .orElseThrow(() -> new AppException(ErrorCode.ROOM_STATUS_NOT_FOUND)));
        
        // Set room type
        room.setRoomTypeId(roomTypeRepository.findById(request.getRoomTypeId())
            .orElseThrow(() -> new AppException(ErrorCode.ROOM_TYPE_NOT_FOUND)));

        room = roomRepository.save(room);
        return roomMapper.toRoomRespone(room);
    }

    public List<RoomResponse> getAllRoom() {
        return roomRepository.findAll().stream().map(roomMapper::toRoomRespone).toList();
    }

    public RoomResponse getRoomById(String roomId) {
        return roomMapper.toRoomRespone(
                roomRepository.findById(roomId).orElseThrow(() -> new AppException(ErrorCode.ROOM_NOT_FOUND)));
    }

    public List<RoomResponse> getAllRoomByUser(String branchId) {
        List<Room> rooms = roomRepository.findAllByBranch_BranchId(branchId);
        if (rooms.isEmpty()) {
            throw new AppException(ErrorCode.ROOM_NOT_FOUND);
        }
        return roomMapper.toRoomRespone(rooms);
    }

    public void deleteRoomById(String roomId) {
        roomRepository.deleteById(roomId);
    }

    public RoomResponse updateRoom(String roomId, RoomUpdateRequest request) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new AppException(ErrorCode.ROOM_NOT_FOUND));

        roomMapper.updateRoom(room, request);

        return roomMapper.toRoomRespone(roomRepository.save(room));
    }
}
