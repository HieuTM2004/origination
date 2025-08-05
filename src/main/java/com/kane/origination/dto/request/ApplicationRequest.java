package com.kane.origination.dto.request;

import jakarta.validation.constraints.NotBlank;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationRequest {
  @NotBlank(message = "Account number is required")
  private String accountNumber;

  @NotBlank(message = "Business decision is required")
  private String businessDecision;

  private OffsetDateTime contractDate;

  @NotBlank(message = "Merchandise type is required")
  private String merchandiseType;

  private Integer status;
}
