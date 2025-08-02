package com.kane.origination.mapper;

import com.kane.origination.dto.request.ApplicantRequest;
import com.kane.origination.dto.response.ApplicantResponse;
import com.kane.origination.model.Applicant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ApplicantMapper {
  @Mapping(source = "addressRequests", target = "addresses")
  Applicant toApplicant(final ApplicantRequest applicantRequest);

  ApplicantResponse toApplicationResponse(final Applicant applicant);
}
