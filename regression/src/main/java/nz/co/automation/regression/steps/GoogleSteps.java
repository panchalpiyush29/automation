package nz.co.automation.regression.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.co.automation.regression.domain.Query;
import nz.co.automation.regression.domain.QueryHolder;
import nz.co.automation.regression.io.JsonReader;
import nz.co.automation.regression.pages.Browser;
import org.springframework.beans.factory.annotation.Autowired;


public class GoogleSteps extends BaseSteps {

    private final Browser browser;
    private JsonReader jsonReader;
    private final QueryHolder queryHolder;

    @Autowired
    public GoogleSteps(Browser browser, JsonReader jsonReader, QueryHolder queryHolder) {
        this.browser = browser;
        this.jsonReader = jsonReader;
        this.queryHolder = queryHolder;
    }

    @Given("^I have a \"([^\"]*)\" search query$")
    public void iHaveASearchQuery(String queryType) {
        Query query = jsonReader.read(queryType, Query.class);
        queryHolder.set(query);
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
