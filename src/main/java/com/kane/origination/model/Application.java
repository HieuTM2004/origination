package com.kane.origination.model;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Application {
  @Id @GeneratedValue private UUID id;

  @Column(nullable = false, name = "account_number", unique = true)
  private String accountNumber;

  @Column(nullable = false, name = "business_decision")
  private String businessDecision;

  @Column(name = "contract_date")
  private OffsetDateTime contractDate;

  @Column(name = "created_time")
  private OffsetDateTime createdTime;

  @Column(nullable = false, name = "merchandise_type")
  private String merchandiseType;

  @Column(name = "product_selected_timestamp")
  private OffsetDateTime productSelectedTimestamp;

  @Column(name = "selected_offer_uuid")
  private UUID selectedOfferUuid;

  @Column(name = "ssn_collected_timestamp")
  private OffsetDateTime ssnCollectedTimestamp;

  @Column(nullable = false)
  private Integer status;

  @Column(name = "updated_time")
  private OffsetDateTime updatedTime;

  @Column(name = "created_by")
  private String createdBy;

  @Column(name = "updated_by")
  private String updatedBy;

  @OneToOne(mappedBy = "application", cascade = CascadeType.ALL)
  private Applicant applicants;
}
