package com.realtime.seatspringbootbackend.src.store.service;

import com.realtime.seatspringbootbackend.src.store.domain.StoreEntity;
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
}
