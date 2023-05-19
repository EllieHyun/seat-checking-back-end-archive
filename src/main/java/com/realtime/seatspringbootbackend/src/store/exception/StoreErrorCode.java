package com.realtime.seatspringbootbackend.src.store.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StoreErrorCode {
    STORE_NOT_FOUND(404, "STORE NOT FOUND"),
    INTER_SERVER_ERROR(500, "INTER SERVER ERROR");

    private final int status;
    private final String message;
}
