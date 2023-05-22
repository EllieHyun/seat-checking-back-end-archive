package com.realtime.seatspringbootbackend.common.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.realtime.seatspringbootbackend.common.code.ResponseCode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Getter
@Builder
@AllArgsConstructor
@JsonPropertyOrder({"success", "code", "message", "status", "timestamp"})
public class ErrorResponse {
    private final boolean isSuccess;
    private final String code;
    private final String message;
    private final int status;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final List<ErrorField> errors;

    private final String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);

    public ErrorResponse(ResponseCode status) {
        this.isSuccess = false;
        this.message = status.getMessage();
        this.status = status.getStatus().value();
        this.errors = Collections.emptyList();
        this.code = status.getCode();
    }

    public ErrorResponse(ResponseCode status, BindingResult bindingResult) {
        this.isSuccess = false;
        this.message = status.getMessage();
        this.status = status.getStatus().value();
        this.errors = ErrorField.of(bindingResult);
        this.code = status.getCode();
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ErrorField {
        private String field;

        private String value;

        private String reason;

        public static List<ErrorField> of(BindingResult bindingResult) {
            try {
                return bindingResult.getAllErrors().stream()
                        .map(
                                error -> {
                                    FieldError fieldError = (FieldError) error;

                                    return new ErrorField(
                                            fieldError.getField(),
                                            Objects.toString(fieldError.getRejectedValue()),
                                            fieldError.getDefaultMessage());
                                })
                        .collect(Collectors.toList());
            } catch (Exception e) {
                return Collections.emptyList();
            }
        }
    }
}
