package nz.co.automation.regression;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = {
        "pretty",
        "html:target/cucumber-html-report",
        "json:target/cucumber-json-report.json",
        "junit:target/cucumber-junit.xml"
},
        tags = {"~@wip", "@regression"}
)
public class CucumberRunner {

}
