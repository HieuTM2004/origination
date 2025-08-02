package com.kane.origination.customValidation;

import com.kane.origination.validator.UniqueEmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class)
public @interface UniqueEmail {
  String message() default "Email must be unique";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
