package com.realtime.seatspringbootbackend.common.annotation.validator;

import com.realtime.seatspringbootbackend.common.annotation.LoginId;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LoginIdValidator implements ConstraintValidator<LoginId, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value.matches("");
    }
}
