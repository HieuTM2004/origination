package com.kane.origination.service;

import com.kane.origination.dto.request.ApplicantRequest;
import com.kane.origination.dto.response.ApplicantResponse;

public interface ApplicantService {
  ApplicantResponse createApplication(final ApplicantRequest applicantRequest, final String name);
}
