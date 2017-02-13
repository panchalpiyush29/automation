package nz.co.automation.regression;

import cucumber.runtime.java.spring.CucumberGlueScopeConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@ComponentScan({"nz.co.automation"})
@Import(CucumberGlueScopeConfiguration.class)
@EnableAutoConfiguration
public class AutomationConfiguration {
}
