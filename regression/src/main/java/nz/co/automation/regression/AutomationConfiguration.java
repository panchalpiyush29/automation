package nz.co.automation.regression;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"nz.co.automation"})
@EnableAutoConfiguration
public class AutomationConfiguration extends SpringBootServletInitializer {

}
