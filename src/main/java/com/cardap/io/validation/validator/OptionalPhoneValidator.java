package com.cardap.io.validation.validator;


import com.cardap.io.validation.annotation.OptionalPhone;
import com.cardap.io.validation.annotation.Phone;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;

public class OptionalPhoneValidator implements ConstraintValidator<OptionalPhone, Optional<String>> {

    @Override
    public void initialize(OptionalPhone constraintAnnotation) {
    }

    @Override
    public boolean isValid(Optional<String> value, ConstraintValidatorContext context) {
      return value.map(s -> !s.isBlank() && s.length() == 11).orElse(true);
    }
}
