package nz.co.automation.regression.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.co.automation.regression.domain.Query;
import nz.co.automation.regression.domain.QueryHolder;
import nz.co.automation.regression.io.ModelFactory;
import nz.co.automation.regression.pages.Browser;
import nz.co.automation.regression.pages.GoogleHomePage;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.Selenide.title;


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
        title().matches("Google");
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

    @Then("^I should see at least (\\d+) correct result$")
    public void iShouldSeeAtLeastCorrectResult(int resultCount) {
        googleHomePage.hasResults(resultCount);
    }
}
