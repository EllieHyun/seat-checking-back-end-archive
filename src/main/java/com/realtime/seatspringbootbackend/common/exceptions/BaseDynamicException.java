package com.realtime.seatspringbootbackend.common.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/** 동적 처리 시 발생하는 예외 */
@Getter
@Builder
@AllArgsConstructor
public class BaseDynamicException extends RuntimeException {
    private final int status;
    private final String code;
    private final String message;
}
