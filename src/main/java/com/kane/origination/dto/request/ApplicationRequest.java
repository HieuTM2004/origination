package com.kane.origination.dto.request;

import jakarta.validation.constraints.NotBlank;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationRequest {
  @NotBlank(message = "Applicant UUID is required")
  private UUID applicantUuid;

  @NotBlank(message = "Account number is required")
  // add annotation for unique account number
  private String accountNumber;

  @NotBlank(message = "Business decision is required")
  private String businessDecision;

  private OffsetDateTime contractDate;

  //  private OffsetDateTime createdTime;

  @NotBlank(message = "Merchandise type is required")
  private String merchandiseType;

  //  private OffsetDateTime productSelectedTimestamp;

  //  private UUID selectedOfferUuid;

  //  private OffsetDateTime ssnCollectedTimestamp;

  private Integer status;

  //  private OffsetDateTime updatedTime;

  //  private String createdBy;

  //  private String updatedBy;
}
