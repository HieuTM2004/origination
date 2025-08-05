package com.kane.origination.dto.request;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationWithApplicantRequest {
  @Valid private ApplicationRequest applicationRequest;

  @Valid private ApplicantRequest applicantRequest;
}
