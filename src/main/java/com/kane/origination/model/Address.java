package com.kane.origination.model;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;

  @Column(nullable = false, unique = true, name = "phone_number")
  private String phoneNumber;

  @Column(nullable = false, name = "address_line1")
  private String addressLine1;

  @Column(name = "address_line2")
  private String addressLine2;

  @Column(nullable = false, unique = true, name = "zip_code")
  private String zipCode;

  @Column(nullable = false)
  private String city;

  @Column(nullable = false)
  private String state;

  @Column(name = "created_time", nullable = false)
  private OffsetDateTime createdTime;

  @Column(name = "updated_time")
  private OffsetDateTime updatedTime;

  @Column(name = "created_by")
  private String createdBy;

  @Column(name = "updated_by")
  private String updatedBy;

  @OneToOne(mappedBy = "addresses")
  private Applicant applicant;
}
