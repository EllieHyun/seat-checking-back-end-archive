package com.realtime.seatspringbootbackend.common.annotation.validator;

import com.realtime.seatspringbootbackend.common.annotation.Nickname;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NicknameValidator implements ConstraintValidator<Nickname, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value.matches("");
    }
}
