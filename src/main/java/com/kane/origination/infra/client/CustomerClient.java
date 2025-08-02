package com.kane.origination.infra.client;

import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service", url = "${customer-service.url}")
public interface CustomerClient {
  @GetMapping("/customer/get-customerUud/{email}")
  UUID getCustomerUudByEmail(@PathVariable String email);
}
