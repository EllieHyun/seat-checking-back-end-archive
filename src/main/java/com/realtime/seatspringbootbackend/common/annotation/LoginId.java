package com.realtime.seatspringbootbackend.common.annotation;

import com.realtime.seatspringbootbackend.common.annotation.validator.LoginIdValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LoginIdValidator.class)
public @interface LoginId {
    String message() default "";
}
