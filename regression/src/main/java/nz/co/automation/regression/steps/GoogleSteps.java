package nz.co.automation.regression.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.co.automation.regression.AutomationConfiguration;
import nz.co.automation.regression.pages.Browser;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AutomationConfiguration.class, loader = SpringBootContextLoader.class)
@SpringBootTest
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

    @Given("^I am on google page$")
    public void iAmOnGooglePage() {
        browser.open("http://www.google.co.nz");
    }

    @Then("^I should see the correct result$")
    public void iShouldSeeTheCorrectResult() {

    }
}
