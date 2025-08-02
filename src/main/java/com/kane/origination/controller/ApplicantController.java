package com.kane.origination.controller;

import com.kane.origination.dto.request.ApplicantRequest;
import com.kane.origination.dto.response.ApplicantResponse;
import com.kane.origination.service.ApplicantService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.util.Base64;
import javax.crypto.SecretKey;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/applicant")
public class ApplicantController {
  private final ApplicantService applicationService;

  @PostMapping("/create-applicant")
  public ResponseEntity<ApplicantResponse> createApplication(
      @Valid @RequestBody ApplicantRequest applicantRequest) {
    log.info("Create applicant: {}", applicantRequest);
    String user = SecurityContextHolder.getContext().getAuthentication().getName();
    log.info("User: {}", user);
    return ResponseEntity.ok(applicationService.createApplication(applicantRequest, user));
  }
}
