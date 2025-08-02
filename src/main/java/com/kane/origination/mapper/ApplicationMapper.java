package com.kane.origination.mapper;

import com.kane.origination.dto.request.ApplicationRequest;
import com.kane.origination.dto.response.ApplicationResponse;
import com.kane.origination.model.Application;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {
  Application toApplication(final ApplicationRequest applicationRequest);

  ApplicationResponse toApplicationResponse(final Application application);
}
