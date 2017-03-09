package nz.co.automation.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan
@EnableAutoConfiguration
@EnableSwagger2
public class RestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class);
    }
}
