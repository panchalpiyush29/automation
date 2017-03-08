package nz.co.automation.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class RestApplication {
  public static void main(String[] args) {
    SpringApplication.run(RestApplication.class);
  }
}
