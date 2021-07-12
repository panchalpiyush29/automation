package nz.co.automation.regression;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"~@wip", "@regression"},
        features = {"src/main/resources/features"}
)
public class CucumberRunner {
}
