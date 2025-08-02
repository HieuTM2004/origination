package com.kane.origination.controller;

import com.kane.origination.dto.request.ApplicationRequest;
import com.kane.origination.dto.request.UpdateApplicationRequest;
import com.kane.origination.dto.response.ApplicationResponse;
import com.kane.origination.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/application")
public class ApplicationController {
  private final ApplicationService applicationService;

  @PostMapping("/create-application")
  public ResponseEntity<ApplicationResponse> createApplication(
      @RequestBody ApplicationRequest applicationRequest) {
    log.info("Create application");
    return ResponseEntity.ok(applicationService.createApplication(applicationRequest));
  }

  @PutMapping("/update-application")
  public ResponseEntity<ApplicationResponse> updateApplication(@RequestBody UpdateApplicationRequest applicationRequest) {
    log.info("Update application");
    return ResponseEntity.ok(applicationService.updateApplication(applicationRequest));
  }
}
