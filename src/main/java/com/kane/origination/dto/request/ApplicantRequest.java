package com.kane.origination.dto.request;

import com.kane.origination.customValidation.UniqueCustomerUUID;
import com.kane.origination.customValidation.UniqueEmail;
import com.kane.origination.customValidation.UniqueMobilePhoneNumber;
import com.kane.origination.customValidation.UniqueVerificationCode;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicantRequest {
  @Email(message = "Invalid email format")
  @NotBlank(message = "Email is required")
  @UniqueEmail
  private String email;

  private Double annualIncome;

  @NotBlank(message = "Mobile phone number is required")
  @Pattern(regexp = "^\\+?[0-9]{9,15}$", message = "Invalid mobile number")
  @UniqueMobilePhoneNumber
  private String mobilePhoneNumber;

  @NotBlank(message = "Verification code is required")
  @UniqueVerificationCode
  private String verificationCode;

  @NotBlank(message = "Last 4 SSN is required")
  private String last4Ssn;

  @UniqueCustomerUUID private UUID customerUuid;

  private boolean mobilePhoneNumberVerified;

  private boolean emailVerified;

  private String newEmailAddress;

  private boolean education;

  private OffsetDateTime verificationCodeExpireAt;

  private AddressRequest addressRequests;
}
