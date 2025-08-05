package com.kane.origination.repo;

import com.kane.origination.model.Applicant;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepo extends JpaRepository<Applicant, UUID> {
  boolean existsByEmail(String email);

  boolean existsByMobilePhoneNumber(String mobilePhoneNumber);

  boolean existsByVerificationCode(String verificationCode);

  boolean existsByCustomerUuid(UUID customerId);
}
