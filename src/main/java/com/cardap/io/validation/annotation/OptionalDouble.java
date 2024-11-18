package com.cardap.io.validation.annotation;

import com.cardap.io.validation.validator.OptionalDoubleValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = OptionalDoubleValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface OptionalDouble {
  String message() default "Invalid double";
  double min() default Double.NEGATIVE_INFINITY;
  double max() default Double.POSITIVE_INFINITY;
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}