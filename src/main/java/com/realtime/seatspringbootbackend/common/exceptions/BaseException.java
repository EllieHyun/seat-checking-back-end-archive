package com.realtime.seatspringbootbackend.common.exceptions;

import com.realtime.seatspringbootbackend.common.code.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BaseException extends RuntimeException {
    private final ResponseCode responseCode;
}
