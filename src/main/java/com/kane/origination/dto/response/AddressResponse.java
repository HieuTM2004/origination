package com.kane.origination.dto.response;

import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {
  private UUID id;

  private String phoneNumber;

  private String addressLine1;

  private String addressLine2;

  private String zipCode;

  private String city;

  private String state;

  private OffsetDateTime createdTime;

  private OffsetDateTime updatedTime;

  private String createdBy;

  private String updatedBy;
}
