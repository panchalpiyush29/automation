package nz.co.automation.regression.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.co.automation.regression.domain.Login;
import nz.co.automation.regression.domain.LoginHolder;
import nz.co.automation.regression.io.ModelFactory;
import nz.co.automation.regression.pages.GmailPage;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    private GmailPage gmailPage;
    private ModelFactory modelFactory;
    private LoginHolder loginHolder;

    @Autowired
    public LoginSteps(GmailPage gmailPage, ModelFactory modelFactory, LoginHolder loginHolder) {
        this.gmailPage = gmailPage;
        this.modelFactory = modelFactory;
        this.loginHolder = loginHolder;

    }

    @Given("^I am a \"([^\"]*)\" user$")
    public void iAmAUser(String loginDetails) throws Throwable {
        Login login = modelFactory.createFromJson(loginDetails, Login.class);
        loginHolder.set(login);
    }

    @When("^I enter my credentials$")
    public void iEnterMyCredentials() throws Throwable {
        Login login = loginHolder.get();
        gmailPage.enterCredentials(login);
    }

    @Then("^I can see my mailbox$")
    public void iCanSeeMyMailbox() throws Throwable {
        assertThat(gmailPage.loggedInUser()).isTrue();
    }

}
