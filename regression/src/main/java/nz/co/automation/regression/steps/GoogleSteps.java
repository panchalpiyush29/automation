package nz.co.automation.regression.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.co.automation.regression.pages.Browser;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration
@ContextConfiguration(loader = SpringBootContextLoader.class)
@SpringBootTest
@ComponentScan(basePackages = {"nz.co.automation", "cucumber.runtime"}, excludeFilters = {
        // We must exclude the following configuration classes because they don't work with the Bigpipe Services setup
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*\\.*Steps.*")})
public class GoogleSteps {

    private final Browser browser;

    @Autowired
    public GoogleSteps(Browser browser) {
        this.browser = browser;
    }

    @Given("^I have a \"([^\"]*)\" search query$")
    public void iHaveASearchQuery(String query) {
    }

    @When("^I search on google$")
    public void iSearchOnGoogle() {
    }

    @Then("^I can see the correct result$")
    public void iCanSeeTheCorrectResult() {
    }

    @Given("^I am on google page$")
    public void iAmOnGooglePage() {
        browser.open("http://www.google.co.nz");
    }
}
