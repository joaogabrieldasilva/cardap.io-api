package com.cardap.io.validation.annotation;

import com.cardap.io.validation.validator.OptionalPhoneValidator;
import com.cardap.io.validation.validator.PhoneValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OptionalPhoneValidator.class)
public @interface OptionalPhone {
  String message() default "{PHONE_INVALID}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
