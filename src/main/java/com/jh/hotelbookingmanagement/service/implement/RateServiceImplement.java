package com.jh.hotelbookingmanagement.service.implement;

import com.jh.hotelbookingmanagement.dto.request.RateRequest;
import com.jh.hotelbookingmanagement.dto.response.RateResponse;
import com.jh.hotelbookingmanagement.entity.Rate;
import com.jh.hotelbookingmanagement.entity.Room;
import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import com.jh.hotelbookingmanagement.mapper.RateMapper;
import com.jh.hotelbookingmanagement.mapper.RoomMapper;
import com.jh.hotelbookingmanagement.repository.RateRepository;
import com.jh.hotelbookingmanagement.repository.RoomRepository;
import com.jh.hotelbookingmanagement.repository.UserRepository;
import com.jh.hotelbookingmanagement.service.RateService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class RateServiceImplement implements RateService {
    private final RoomRepository roomRepository;
    UserRepository userRepository;
    RateRepository rateRepository;
    RateMapper rateMapper;

    @Override
    public RateResponse createRate(RateRequest request) {
        Rate rate = rateMapper.toRate(request);
        rate.setRatedBy(userRepository.findById(request.getRatedBy()).orElseThrow(()->new AppException(ErrorCode.USER_NOT_EXISTED)));
        Room room = roomRepository.findById(request.getRoomId()).orElseThrow(()->new AppException(ErrorCode.ROOM_NOT_FOUND));
        rate.setRoom(room);
        rate.setRateDate(new Date());
        rate = rateRepository.save(rate);
        return rateMapper.toRateResponse(rate);
    }

    @Override
    public List<RateResponse> getAllRate() {
        return rateRepository.findAll().stream()
                .map(rateMapper::toRateResponse).toList();
    }

    @Override
    public RateResponse updateRate(Long rateId, RateRequest request) {
        Rate rate = rateRepository.findById(rateId)
                .orElseThrow(()->new AppException(ErrorCode.BOOKING_METHOD_NOT_FOUND));
        rateMapper.updateRate(rate, request);
        return rateMapper.toRateResponse(rateRepository.save(rate));
    }

    @Override
    public void deleteRate(Long rateId) {
        rateRepository.deleteById(rateId);
    }
}
