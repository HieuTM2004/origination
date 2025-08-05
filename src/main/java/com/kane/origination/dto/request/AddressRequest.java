package com.kane.origination.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {
  @NotBlank(message = "Phone number is required")
  @Pattern(regexp = "^\\+?[0-9]{9,15}$", message = "Invalid mobile number")
  private String phoneNumber;

  @NotBlank(message = "Address line 1 is required")
  private String addressLine1;

  private String addressLine2;

  @NotBlank(message = "Zip code is required")
  private String zipCode;

  @NotBlank(message = "City is required")
  private String city;

  @NotBlank(message = "State is required")
  private String state;
}
