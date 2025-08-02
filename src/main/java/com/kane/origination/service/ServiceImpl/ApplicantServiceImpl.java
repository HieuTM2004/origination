package com.kane.origination.service.ServiceImpl;

import com.kane.origination.dto.request.AddressRequest;
import com.kane.origination.dto.request.ApplicantRequest;
import com.kane.origination.dto.response.ApplicantResponse;
import com.kane.origination.infra.client.CustomerClient;
import com.kane.origination.mapper.AddressMapper;
import com.kane.origination.mapper.ApplicantMapper;
import com.kane.origination.model.Address;
import com.kane.origination.model.Applicant;
import com.kane.origination.repo.AddressRepo;
import com.kane.origination.repo.ApplicantRepo;
import com.kane.origination.service.ApplicantService;
import java.time.OffsetDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicantServiceImpl implements ApplicantService {
  private final ApplicantMapper applicantMapper;
  private final ApplicantRepo applicantRepo;
  private final AddressMapper addressMapper;
  private final AddressRepo addressRepo;
  private final CustomerClient customerClient;

  @Override
  public ApplicantResponse createApplication(ApplicantRequest applicantRequest, String name) {
    AddressRequest addressRequest = applicantRequest.getAddressRequests();
    Address address = addressMapper.toAddress(addressRequest);
    address.setCreatedTime(OffsetDateTime.now());
    address.setUpdatedTime(OffsetDateTime.now());
    address.setCreatedBy(name);
    address.setUpdatedBy(name);
    addressRepo.save(address);

    Applicant applicant = applicantMapper.toApplicant(applicantRequest);
    applicant.setAddresses(address);
    applicant.setCreatedTime(OffsetDateTime.now());
    applicant.setUpdatedTime(OffsetDateTime.now());
    log.info("applicant address: {}", applicant.getAddresses());
    applicant.setCreatedBy(name);
    applicant.setUpdatedBy(name);
    applicant.setCreatedTime(OffsetDateTime.now());
    applicant.setUpdatedTime(OffsetDateTime.now());

    applicant.setCustomerUuid(customerClient.getCustomerUudByEmail(name));

    applicant.setAddresses(address);

    applicantRepo.save(applicant);
    Applicant test = new Applicant();
    test =
        applicantRepo
            .findById(applicant.getId())
            .orElseThrow(
                () -> new RuntimeException("Applicant not found with id: " + applicant.getId()));
    return applicantMapper.toApplicationResponse(test);
  }
}
