package com.kane.origination.dto.response;

import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicantResponse {
  private UUID id;

  private String email;

  private Double annualIncome;

  private OffsetDateTime createdTime;

  private String mobilePhoneNumber;

  private String verificationCode;

  private String last4Ssn;

  private UUID customerUuid;

  private boolean mobilePhoneNumberVerified;

  private boolean emailVerified;

  private String newEmailAddress;

  private boolean education;

  private OffsetDateTime verificationCodeExpireAt;

  private OffsetDateTime updatedTime;

  private String createdBy;

  private String updatedBy;

  private AddressResponse addresses;
}
