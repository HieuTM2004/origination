package com.kane.origination.service;

import com.kane.origination.dto.request.ApplicationWithApplicantRequest;
import com.kane.origination.dto.request.UpdateApplicationRequest;
import com.kane.origination.dto.response.ApplicationResponse;

public interface ApplicationService {
  ApplicationResponse createApplication(
      final ApplicationWithApplicantRequest applicationWithApplicantRequest);

  ApplicationResponse updateApplication(final UpdateApplicationRequest updateApplicationRequest);
}
