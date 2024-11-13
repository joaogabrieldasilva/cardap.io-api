package com.cardap.io.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = com.cardap.io.validation.annotation.OptionalSizeValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface OptionalSize {
  String message() default "Size must be between {min} and {max}";
  int min() default 0;
  int max() default Integer.MAX_VALUE;
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}