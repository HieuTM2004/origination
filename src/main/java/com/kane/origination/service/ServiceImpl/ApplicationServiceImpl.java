package com.kane.origination.service.ServiceImpl;

import com.kane.origination.dto.request.AddressRequest;
import com.kane.origination.dto.request.ApplicationWithApplicantRequest;
import com.kane.origination.dto.request.UpdateApplicationRequest;
import com.kane.origination.dto.response.ApplicationResponse;
import com.kane.origination.infra.client.CustomerClient;
import com.kane.origination.mapper.AddressMapper;
import com.kane.origination.mapper.ApplicantMapper;
import com.kane.origination.mapper.ApplicationMapper;
import com.kane.origination.model.Address;
import com.kane.origination.model.Applicant;
import com.kane.origination.model.Application;
import com.kane.origination.repo.AddressRepo;
import com.kane.origination.repo.ApplicationRepo;
import com.kane.origination.service.ApplicationService;
import java.time.OffsetDateTime;
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

  private final ApplicantMapper applicantMapper;
  private final AddressMapper addressMapper;
  private final AddressRepo addressRepo;
  private final CustomerClient customerClient;

  @Override
  public ApplicationResponse createApplication(
      ApplicationWithApplicantRequest applicationWithApplicantRequest) {
    log.info("Application request received: {}", applicationWithApplicantRequest);

    String user = SecurityContextHolder.getContext().getAuthentication().getName();
    log.info("Creating application for user: {}", user);

    AddressRequest addressRequest =
        applicationWithApplicantRequest.getApplicantRequest().getAddressRequests();
    Address address = addressMapper.toAddress(addressRequest);
    address.setCreatedTime(OffsetDateTime.now());
    address.setUpdatedTime(OffsetDateTime.now());
    address.setCreatedBy(user);
    address.setUpdatedBy(user);
    addressRepo.save(address);

    Applicant applicant =
        applicantMapper.toApplicant(applicationWithApplicantRequest.getApplicantRequest());
    applicant.setAddresses(address);
    applicant.setCreatedTime(OffsetDateTime.now());
    applicant.setUpdatedTime(OffsetDateTime.now());
    log.info("applicant address: {}", applicant.getAddresses());
    applicant.setCreatedBy(user);
    applicant.setUpdatedBy(user);
    applicant.setCreatedTime(OffsetDateTime.now());
    applicant.setUpdatedTime(OffsetDateTime.now());

    applicant.setCustomerUuid(customerClient.getCustomerUudByEmail(user));

    applicant.setAddresses(address);

    //    applicantRepo.save(applicant);

    Application application =
        this.applicationMapper.toApplication(
            applicationWithApplicantRequest.getApplicationRequest());

    application.setCreatedTime(OffsetDateTime.now());
    application.setUpdatedTime(OffsetDateTime.now());
    application.setSsnCollectedTimestamp(OffsetDateTime.now());

    application.setCreatedBy(user);
    application.setUpdatedBy(user);
    application.setApplicants(applicant);

    applicant.setApplication(application);

    applicationRepo.save(application);

    return applicationMapper.toApplicationResponse(application);
  }

  @Override
  public ApplicationResponse updateApplication(UpdateApplicationRequest updateApplicationRequest) {
    Application application =
        applicationRepo
            .findById(updateApplicationRequest.getApplicationUuid())
            .orElseThrow(
                () ->
                    new RuntimeException(
                        "Application not found with id: "
                            + updateApplicationRequest.getApplicationUuid()));

    application.setSelectedOfferUuid(updateApplicationRequest.getProductId());
    application.setUpdatedTime(OffsetDateTime.now());
    application.setProductSelectedTimestamp(OffsetDateTime.now());

    String user = SecurityContextHolder.getContext().getAuthentication().getName();
    application.setUpdatedBy(user);

    applicationRepo.save(application);
    return applicationMapper.toApplicationResponse(application);
  }
}
