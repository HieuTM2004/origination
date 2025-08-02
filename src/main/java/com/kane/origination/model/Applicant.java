package com.kane.origination.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Applicant {
  @Id @GeneratedValue private UUID id;

  @Email
  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false, name = "annual_income")
  private Double annualIncome;

  @Column(name = "created_time")
  private OffsetDateTime createdTime;

  @Column(name = "mobile_phone_number", nullable = false, unique = true)
  private String mobilePhoneNumber;

  @Column(nullable = false, name = "verification_code", unique = true)
  private String verificationCode;

  @Column(nullable = false, name = "last4_ssn", unique = true)
  private String last4Ssn;

  @Column(nullable = false, name = "customer_uuid", unique = true)
  private UUID customerUuid;

  @Column(name = "mobile_phone_number_verified")
  private boolean mobilePhoneNumberVerified;

  @Column(name = "email_verified")
  private boolean emailVerified;

  @Email
  @Column(name = "new_email_address", unique = true)
  private String newEmailAddress;

  @Column(nullable = false)
  private boolean education;

  @Column(name = "verification_code_expire_at")
  private OffsetDateTime verificationCodeExpireAt;

  @Column(name = "updated_time")
  private OffsetDateTime updatedTime;

  @Column(name = "created_by")
  private String createdBy;

  @Column(name = "updated_by")
  private String updatedBy;

  @OneToOne
  @JoinColumn(name = "application_uuid")
  private Application application;

  @OneToOne
  @JoinColumn(name = "address_id")
  private Address addresses;
}
