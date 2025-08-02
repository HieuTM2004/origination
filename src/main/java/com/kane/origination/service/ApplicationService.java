package com.kane.origination.service;

import com.kane.origination.dto.request.ApplicationRequest;
import com.kane.origination.dto.request.UpdateApplicationRequest;
import com.kane.origination.dto.response.ApplicationResponse;

public interface ApplicationService {
  ApplicationResponse createApplication(final ApplicationRequest applicationRequest);

    ApplicationResponse updateApplication(final UpdateApplicationRequest updateApplicationRequest);
}
