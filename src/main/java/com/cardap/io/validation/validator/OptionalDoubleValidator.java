package com.cardap.io.validation.validator;

import com.cardap.io.validation.annotation.OptionalDouble;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Optional;

public class OptionalDoubleValidator implements ConstraintValidator<OptionalDouble, Optional<Double>> {
  private double min;
  private double max;

  @Override
  public void initialize(OptionalDouble constraintAnnotation) {
    this.min = constraintAnnotation.min();
    this.max = constraintAnnotation.max();
  }

  @Override
  public boolean isValid(Optional<Double> value, ConstraintValidatorContext context) {
    if (value.isEmpty()) {
      return true;
    }
    Double dbl = value.get();
    return dbl >= min && dbl <= max;
  }
}