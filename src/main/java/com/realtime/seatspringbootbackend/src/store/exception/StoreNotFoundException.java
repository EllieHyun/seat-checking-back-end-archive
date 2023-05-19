package com.realtime.seatspringbootbackend.src.store.exception;

import lombok.Getter;

@Getter
public class StoreNotFoundException extends Exception{

    private final StoreErrorCode storeErrorCode;

    public StoreNotFoundException(StoreErrorCode storeErrorCode) {
        super(storeErrorCode.getMessage());
        this.storeErrorCode = storeErrorCode;
    }
}
