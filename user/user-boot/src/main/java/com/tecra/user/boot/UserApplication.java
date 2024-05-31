package com.tecra.user.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.tecra.user")
public class UserApplication {

  public static void main(final String[] args) {
    SpringApplication.run(UserApplication.class, args);
  }
}
