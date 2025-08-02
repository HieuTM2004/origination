package com.kane.origination.customValidation;

import com.kane.origination.validator.UniqueVerificationCodeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueVerificationCodeValidator.class)
public @interface UniqueVerificationCode {
  String message() default "Verification code must be unique";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
