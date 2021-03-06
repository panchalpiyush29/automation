package nz.co.automation.rest.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static com.google.common.base.Predicates.or;

@Configuration
public class SwaggerConfiguration {

  @Bean
  public Docket restDocumentation() {
    return new Docket(DocumentationType.SWAGGER_2)
            .groupName("rest")
            .apiInfo(apiInfo())
            .select()
            .paths(or(PathSelectors.regex(".*/api/v1/.*")))
            .build()
            .useDefaultResponseMessages(false)
            .forCodeGeneration(true);
  }

  @Bean
  public Docket allDocumentation() {
    return new Docket(DocumentationType.SWAGGER_2)
            .groupName("all")
            .apiInfo(apiInfo())
            .select()
            .build()
            .useDefaultResponseMessages(false)
            .forCodeGeneration(true);
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("Rest Services")
            .description("Rest Services Playground")
            .termsOfServiceUrl("http://www.dogs.co.nz")
            .version("1.0")
            .build();
  }
}
