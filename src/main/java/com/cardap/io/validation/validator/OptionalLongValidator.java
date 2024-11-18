package com.cardap.io.validation.validator;

import com.cardap.io.validation.annotation.OptionalLong;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;

public class OptionalLongValidator implements ConstraintValidator<OptionalLong, Optional<Long>> {

    @Override
    public boolean isValid(Optional<Long> value, ConstraintValidatorContext context) {
        return value == null || value.isEmpty() || value.get() > 0;
    }
}