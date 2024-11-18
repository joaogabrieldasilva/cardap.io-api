package com.cardap.io.validation.annotation;

import com.cardap.io.validation.validator.OptionalLongValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = OptionalLongValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface OptionalLong {
    String message() default "Invalid long value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}