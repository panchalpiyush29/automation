package nz.co.automation.regression;

import cucumber.runtime.java.spring.CucumberGlueScopeConfiguration;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.Collections;
import java.util.List;

@ComponentScan({"nz.co.automation"})
@Import(CucumberGlueScopeConfiguration.class)
@EnableAutoConfiguration
@EnableAspectJAutoProxy
public class AutomationConfiguration {

  @Autowired
  Environment environment;

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public ReportBuilder reportBuilder() {
    // json files
    List<String> jsonFiles = Collections.singletonList("target/cucumber-json-report.json");

    // configuration
    File reportOutputDirectory = new File("target");
    String projectName = environment.getProperty("user.dir");
    Configuration configuration = new Configuration(reportOutputDirectory, projectName);

    // initialise report builder
    return new ReportBuilder(jsonFiles, configuration);
  }
}
