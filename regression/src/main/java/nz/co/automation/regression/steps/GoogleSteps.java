package nz.co.automation.regression.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.co.automation.regression.AutomationConfiguration;
import nz.co.automation.regression.io.JsonReader;
import nz.co.automation.regression.pages.Browser;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


public class GoogleSteps extends BaseSteps {

    private final Browser browser;
    private JsonReader jsonReader;

    @Autowired
    public GoogleSteps(Browser browser, JsonReader jsonReader) {
        this.browser = browser;
        this.jsonReader = jsonReader;
    }

    @Given("^I have a \"([^\"]*)\" search query$")
    public void iHaveASearchQuery(String query) {
        //jsonReader.read(query,Query.class);
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
