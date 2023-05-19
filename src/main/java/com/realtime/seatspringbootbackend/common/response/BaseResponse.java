package com.realtime.seatspringbootbackend.common.response;

import static com.realtime.seatspringbootbackend.common.code.ResponseCode.SUCCESS;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result", "timestamp"})
public class BaseResponse {
    @JsonProperty("isSuccess")
    private final Boolean isSuccess = true;

    private final String message;

    private final int status;
    private final String code;

    private final String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object result;

    // 요청에 성공한 경우
    public BaseResponse(int status, Object result) {
        this.message = SUCCESS.getMessage();
        this.code = SUCCESS.getCode();
        this.status = status;
        this.result = result;
    }
}
