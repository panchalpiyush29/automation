package nz.co.automation.regression.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSteps {
    @Given("^I am google page$")
    public void iAmGooglePage() {
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
}
