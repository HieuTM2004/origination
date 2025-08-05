package com.kane.origination.mapper;

import com.kane.origination.dto.request.ApplicationRequest;
import com.kane.origination.dto.response.ApplicationResponse;
import com.kane.origination.model.Application;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {
  Application toApplication(final ApplicationRequest applicationRequest);

  @Mapping(source = "applicants", target = "applicantResponse")
  ApplicationResponse toApplicationResponse(final Application application);
}
