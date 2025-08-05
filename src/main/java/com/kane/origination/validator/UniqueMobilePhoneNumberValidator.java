package com.kane.origination.validator;

import com.kane.origination.customValidation.UniqueMobilePhoneNumber;
import com.kane.origination.repo.ApplicantRepo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniqueMobilePhoneNumberValidator
    implements ConstraintValidator<UniqueMobilePhoneNumber, String> {
  private final ApplicantRepo applicantRepo;

  @Override
  public boolean isValid(String applicantRequest, ConstraintValidatorContext context) {
    if (applicantRequest == null) {
      return true;
    }
    return !applicantRepo.existsByMobilePhoneNumber(applicantRequest);
  }
}
