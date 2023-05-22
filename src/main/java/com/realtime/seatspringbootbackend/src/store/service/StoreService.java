package com.realtime.seatspringbootbackend.src.store.service;

import com.realtime.seatspringbootbackend.common.utils.EnumUtils;
import com.realtime.seatspringbootbackend.src.store.domain.StoreEntity;
import com.realtime.seatspringbootbackend.src.store.dto.request.StoreCreateRequestDto;
import com.realtime.seatspringbootbackend.src.store.exception.StoreErrorCode;
import com.realtime.seatspringbootbackend.src.store.repository.StoreRepository;
import com.realtime.seatspringbootbackend.src.store.exception.StoreNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreEntity findById(Long id) throws Exception {
        return storeRepository.findById(id).orElseThrow(() -> new StoreNotFoundException(StoreErrorCode.STORE_NOT_FOUND));
    }

    public StoreEntity save(StoreCreateRequestDto storeCreateRequestDto) {
        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setName(storeCreateRequestDto.getName());
        storeEntity.setIntroduction(storeCreateRequestDto.getIntroduction());
        storeEntity.setLocation(storeCreateRequestDto.getLocation());
        storeEntity.setTotalFloor(storeEntity.getTotalFloor());
        storeEntity.setKind(storeCreateRequestDto.getKind());
        storeEntity.setDayOff(EnumUtils.getEnumListAsString(storeCreateRequestDto.getDayOff()));
        storeEntity.setMonBusinessHours(storeCreateRequestDto.getMonBusinessHours());
        storeEntity.setTueBusinessHours(storeCreateRequestDto.getTueBusinessHours());
        storeEntity.setWedBusinessHours(storeCreateRequestDto.getWedBusinessHours());
        storeEntity.setThuBusinessHours(storeCreateRequestDto.getThuBusinessHours());
        storeEntity.setFriBusinessHours(storeCreateRequestDto.getFriBusinessHours());
        storeEntity.setSunBusinessHours(storeCreateRequestDto.getSunBusinessHours());
        storeEntity.setBreakTime(storeCreateRequestDto.getBreakTime());
        storeEntity.setUseTimeLimit(storeCreateRequestDto.getUseTimeLimit());
        return storeRepository.save(storeEntity);
    }
}
