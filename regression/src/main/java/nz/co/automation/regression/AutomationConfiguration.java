package nz.co.automation.regression;

import cucumber.runtime.java.spring.CucumberGlueScopeConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

@ComponentScan({"nz.co.automation"})
@Import(CucumberGlueScopeConfiguration.class)
@EnableAutoConfiguration
public class AutomationConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
