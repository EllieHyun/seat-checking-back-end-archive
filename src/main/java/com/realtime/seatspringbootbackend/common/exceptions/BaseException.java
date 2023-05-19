package com.realtime.seatspringbootbackend.common.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BaseException extends RuntimeException {
    private final ErrorCode errorCode;

    public static BaseException from(ErrorCode errorCode) {
        return new BaseException(errorCode);
    }
}
