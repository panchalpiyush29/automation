package cucumber.runtime.java.spring;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This is a hack to ge the {@code cucumber-glue} Spring scope to work. Hopefully this gets fixed in cucumber soon.
 */
@Configuration
public class CucumberGlueScopeConfiguration {

    @Bean
    public CustomScopeConfigurer glueScopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("cucumber-glue", new GlueCodeScope());
        return configurer;
    }
}
