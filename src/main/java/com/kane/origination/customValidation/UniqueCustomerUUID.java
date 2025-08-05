package com.kane.origination.customValidation;

import com.kane.origination.validator.UniqueCustomerUUIDValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueCustomerUUIDValidator.class)
public @interface UniqueCustomerUUID {
  String message() default "Customer UUID must be unique";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
