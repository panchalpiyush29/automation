package nz.co.automation.regression;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "(@regression)",
        features = {"src/main/resources/features"}

)
public class CucumberRunner {
}
