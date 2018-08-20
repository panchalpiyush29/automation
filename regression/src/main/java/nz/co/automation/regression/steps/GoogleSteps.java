package nz.co.automation.regression.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.co.automation.regression.domain.Query;
import nz.co.automation.regression.domain.QueryHolder;
import nz.co.automation.regression.io.ModelFactory;
import nz.co.automation.regression.pages.Browser;
import nz.co.automation.regression.pages.GoogleHomePage;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;


public class GoogleSteps {

    private final Browser browser;
    private ModelFactory modelFactory;
    private final QueryHolder queryHolder;
    private final GoogleHomePage googleHomePage;


    @Autowired
    public GoogleSteps(Browser browser, ModelFactory modelFactory, QueryHolder queryHolder, GoogleHomePage googleHomePage) {
        this.browser = browser;
        this.modelFactory = modelFactory;
        this.queryHolder = queryHolder;
        this.googleHomePage = googleHomePage;
    }

    @Given("^I am on google page$")
    public void iAmOnGooglePage() {
        browser.visitBaseUrl();
    }

    @Given("^I have a \"([^\"]*)\" search query$")
    public void iHaveASearchQuery(String queryType) {
        Query query = modelFactory.createFromJson(queryType, Query.class);
        queryHolder.set(query);
    }

    @When("^I perform a search on google landing page$")
    public void iPerformASearchOnGoogleLandingPage() {
        Query query = queryHolder.get();
        googleHomePage.search(query);
    }

    @Then("^I should see the correct result$")
    public void iShouldSeeTheCorrectResult() {
        assertThat(googleHomePage.hasResults()).isTrue();
    }
}
