package nz.co.mobile;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.runtime.java.spring.CucumberGlueScopeConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@ComponentScan({"nz.co.mobile"})
@Import(CucumberGlueScopeConfiguration.class)
@EnableAutoConfiguration
public class AutomationConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper;
    }
}
