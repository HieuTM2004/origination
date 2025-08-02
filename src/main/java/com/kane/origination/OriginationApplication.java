package com.kane.origination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kane.origination", "com.kane.common"})
@EnableFeignClients
@EnableAspectJAutoProxy
public class OriginationApplication {

  public static void main(String[] args) {
    SpringApplication.run(OriginationApplication.class, args);
  }
}
