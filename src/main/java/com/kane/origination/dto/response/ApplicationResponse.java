package com.kane.origination.dto.response;

import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationResponse {
  private UUID id;

  private String accountNumber;

  private String businessDecision;

  private OffsetDateTime contractDate;

  private OffsetDateTime createdTime;

  private String merchandiseType;

  private OffsetDateTime productSelectedTimestamp;

  private UUID selectedOfferUuid;

  private OffsetDateTime ssnCollectedTimestamp;

  private Integer status;

  private OffsetDateTime updatedTime;

  private String createdBy;

  private String updatedBy;
}
