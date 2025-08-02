package com.kane.origination.validator;

import com.kane.origination.customValidation.UniqueEmail;
import com.kane.origination.repo.ApplicantRepo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
  private final ApplicantRepo applicantRepo;

  @Override
  public boolean isValid(String text, ConstraintValidatorContext context) {
    if (text == null) {
      return true;
    }
    return !applicantRepo.existsByEmail(text);
  }
}
