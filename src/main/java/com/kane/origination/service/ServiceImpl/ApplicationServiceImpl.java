package com.kane.origination.service.ServiceImpl;

import com.kane.origination.dto.request.ApplicationRequest;
import com.kane.origination.dto.request.UpdateApplicationRequest;
import com.kane.origination.dto.response.ApplicationResponse;
import com.kane.origination.mapper.ApplicationMapper;
import com.kane.origination.model.Applicant;
import com.kane.origination.model.Application;
import com.kane.origination.repo.ApplicantRepo;
import com.kane.origination.repo.ApplicationRepo;
import com.kane.origination.service.ApplicationService;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
  private final ApplicationRepo applicationRepo;
  private final ApplicationMapper applicationMapper;
  private final ApplicantRepo applicantRepo;

  @Override
  public ApplicationResponse createApplication(ApplicationRequest applicationRequest) {
    log.info("Application request received: {}", applicationRequest);
    Application application = this.applicationMapper.toApplication(applicationRequest);

    application.setCreatedTime(OffsetDateTime.now());
    application.setUpdatedTime(OffsetDateTime.now());
    application.setSsnCollectedTimestamp(OffsetDateTime.now());

    String user = SecurityContextHolder.getContext().getAuthentication().getName();
    log.info("Creating application for user: {}", user);
    application.setCreatedBy(user);
    application.setUpdatedBy(user);

    applicationRepo.save(application);

    UUID id = applicationRequest.getApplicantUuid();
    Applicant applicant =
        applicantRepo
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Application not found with id: " + id));

    applicant.setApplication(application);
    applicantRepo.save(applicant);
    return applicationMapper.toApplicationResponse(application);
  }

  @Override
  public ApplicationResponse updateApplication(UpdateApplicationRequest updateApplicationRequest) {
    Application application =
        applicationRepo
            .findById(updateApplicationRequest.getApplicationUuid())
            .orElseThrow(() -> new RuntimeException("Application not found with id: " + updateApplicationRequest.getApplicationUuid()));

    application.setSelectedOfferUuid(updateApplicationRequest.getProductId());
    application.setUpdatedTime(OffsetDateTime.now());
    application.setProductSelectedTimestamp(OffsetDateTime.now());

    String user = SecurityContextHolder.getContext().getAuthentication().getName();
    application.setUpdatedBy(user);

    applicationRepo.save(application);
    return applicationMapper.toApplicationResponse(application);
  }
}
