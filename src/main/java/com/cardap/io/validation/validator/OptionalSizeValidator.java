package com.cardap.io.validation.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Optional;

public class OptionalSizeValidator implements ConstraintValidator<OptionalSize, Optional<String>> {
  private int min;
  private int max;

  @Override
  public void initialize(OptionalSize constraintAnnotation) {
    this.min = constraintAnnotation.min();
    this.max = constraintAnnotation.max();
  }

  @Override
  public boolean isValid(Optional<String> value, ConstraintValidatorContext context) {
    if (value.isEmpty()) {
      return true;
    }
    String str = value.get();
    return str.length() >= min && str.length() <= max;
  }
}