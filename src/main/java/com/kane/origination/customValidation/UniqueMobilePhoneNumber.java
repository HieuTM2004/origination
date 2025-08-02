package com.kane.origination.customValidation;

import com.kane.origination.validator.UniqueMobilePhoneNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueMobilePhoneNumberValidator.class)
public @interface UniqueMobilePhoneNumber {
  String message() default "Mobile phone number must be unique";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
