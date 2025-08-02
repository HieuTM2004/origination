package com.kane.origination.validator;

import com.kane.origination.customValidation.UniqueVerificationCode;
import com.kane.origination.repo.ApplicantRepo;
import jakarta.validation.ConstraintValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniqueVerificationCodeValidator
    implements ConstraintValidator<UniqueVerificationCode, String> {
  private final ApplicantRepo applicantRepo;

  @Override
  public boolean isValid(
      String applicantRequest, jakarta.validation.ConstraintValidatorContext context) {
    if (applicantRequest == null) {
      return true;
    }
    return !applicantRepo.existsByVerificationCode(applicantRequest);
  }
}
