package nz.co.automation.regression.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.co.automation.regression.domain.Login;
import nz.co.automation.regression.domain.LoginHolder;
import nz.co.automation.regression.io.ModelFactory;
import nz.co.automation.regression.pages.SPBLoginPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class SPBDemoSteps {


    private ModelFactory modelFactory;
    private final LoginHolder loginHolder;
    private final SPBLoginPage sbpLoginPage;
    private final String spbLoginUrl;

    @Autowired
    public SPBDemoSteps(ModelFactory modelFactory, LoginHolder loginHolder, SPBLoginPage sbpLoginPage,
                        @Value("${spblogin.url}") String spbLoginUrl) {

        this.modelFactory = modelFactory;
        this.loginHolder = loginHolder;
        this.sbpLoginPage = sbpLoginPage;
        this.spbLoginUrl = spbLoginUrl;
    }

    @Given("^User is on SPB Demo login page$")
    public void userIsOnSPBDemoLoginPage() {
        open(spbLoginUrl);
    }

    @When("^User enters \"([^\"]*)\" credentials$")
    public void userEntersCredentials(String credentials) {
        Login login = modelFactory.createFromJson(credentials, Login.class);
        loginHolder.set(login);
        sbpLoginPage.enterCredentials(login);
    }

    @Then("^User greeting \"([^\"]*)\" is displayed$")
    public void userGreetingIsDisplayed(String name) {
        assertThat(sbpLoginPage.userGreeting().equals(name));
    }
}