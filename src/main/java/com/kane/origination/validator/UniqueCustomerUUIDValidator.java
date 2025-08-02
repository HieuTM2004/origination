package com.kane.origination.validator;

import com.kane.origination.customValidation.UniqueCustomerUUID;
import com.kane.origination.repo.ApplicantRepo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniqueCustomerUUIDValidator implements ConstraintValidator<UniqueCustomerUUID, UUID> {
  private final ApplicantRepo applicantRepo;

  @Override
  public boolean isValid(UUID id, ConstraintValidatorContext context) {
    if (id == null) {
      return true;
    }
    return !applicantRepo.existsByCustomerUuid(id);
  }
}
