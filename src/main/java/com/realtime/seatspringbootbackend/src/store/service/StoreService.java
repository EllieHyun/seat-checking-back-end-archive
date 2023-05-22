package com.realtime.seatspringbootbackend.src.store.service;

import com.realtime.seatspringbootbackend.common.code.ResponseCode;
import com.realtime.seatspringbootbackend.common.entity.BaseEntity;
import com.realtime.seatspringbootbackend.common.utils.EnumUtils;
import com.realtime.seatspringbootbackend.src.store.domain.StoreEntity;
import com.realtime.seatspringbootbackend.src.store.dto.request.StoreCreateRequestDto;
import com.realtime.seatspringbootbackend.src.store.dto.request.StoreUpdateRequestDto;
import com.realtime.seatspringbootbackend.src.store.exception.StoreNotFoundException;
import com.realtime.seatspringbootbackend.src.store.repository.StoreRepository;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreEntity findById(Long id) throws Exception {
        return storeRepository
                .findById(id)
                .orElseThrow(() -> new StoreNotFoundException(ResponseCode.STORE_NOT_FOUND));
    }

    public void save(StoreCreateRequestDto storeCreateRequestDto) {
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
    }

    @Transactional
    public void update(Long id, StoreUpdateRequestDto storeUpdateRequestDto)
            throws StoreNotFoundException {
        StoreEntity storeEntity =
                storeRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new StoreNotFoundException(ResponseCode.STORE_NOT_FOUND));
        storeEntity.setName(storeUpdateRequestDto.getName());
        storeEntity.setIntroduction(storeUpdateRequestDto.getIntroduction());
        storeEntity.setLocation(storeUpdateRequestDto.getLocation());
        storeEntity.setTotalFloor(storeEntity.getTotalFloor());
        storeEntity.setKind(storeUpdateRequestDto.getKind());
        storeEntity.setDayOff(EnumUtils.getEnumListAsString(storeUpdateRequestDto.getDayOff()));
        storeEntity.setMonBusinessHours(storeUpdateRequestDto.getMonBusinessHours());
        storeEntity.setTueBusinessHours(storeUpdateRequestDto.getTueBusinessHours());
        storeEntity.setWedBusinessHours(storeUpdateRequestDto.getWedBusinessHours());
        storeEntity.setThuBusinessHours(storeUpdateRequestDto.getThuBusinessHours());
        storeEntity.setFriBusinessHours(storeUpdateRequestDto.getFriBusinessHours());
        storeEntity.setSunBusinessHours(storeUpdateRequestDto.getSunBusinessHours());
        storeEntity.setBreakTime(storeUpdateRequestDto.getBreakTime());
        storeEntity.setUseTimeLimit(storeUpdateRequestDto.getUseTimeLimit());
    }

    @Transactional
    public void delete(Long id) throws StoreNotFoundException {
        StoreEntity storeEntity =
                storeRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new StoreNotFoundException(ResponseCode.STORE_NOT_FOUND));
        storeEntity.setState(BaseEntity.State.INACTIVE);
    }
}
