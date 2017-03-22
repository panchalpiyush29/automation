package nz.co.mobile.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.co.mobile.domain.ModelFactory;
import nz.co.mobile.domain.UserDetails;
import nz.co.mobile.holder.UserDetailsHolder;
import nz.co.mobile.screen.LoginScreen;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps extends BaseSteps {
    private UserDetailsHolder userDetailsHolder;
    private LoginScreen loginScreen;
    private ModelFactory modelFactory;

    @Autowired
    public LoginSteps(UserDetailsHolder userDetailsHolder, LoginScreen loginScreen, ModelFactory modelFactory) {
        this.userDetailsHolder = userDetailsHolder;
        this.loginScreen = loginScreen;
        this.modelFactory = modelFactory;
    }

    @Given("^I am a \"([^\"]*)\" user$")
    public void iAmAUser(String userType) {
        final UserDetails userDetails = modelFactory.create(UserDetails.class, userType);
        userDetailsHolder.set(userDetails);
    }

    @When("^I login as the user$")
    public void iLoginAsTheUser() {
        UserDetails userDetails = userDetailsHolder.get();
        loginScreen.enterEmail(userDetails.getEmail());
        loginScreen.enterPassword(userDetails.getPassword());
        loginScreen.clickSignIn();
    }

    @Then("^I can see the welcome page after skipping the welcome video$")
    public void iCanSeeTheWelcomePageAfterSkippingTheWelcomeVideo() {
        loginScreen.dismissNotification();
        assertThat(loginScreen.isDisplayingTheWelcomeToSparkMessage()).isTrue();
    }

    @Given("^I navigate to the set up access card section$")
    public void iNavigateToTheSetUpAccessCardSection() {
        loginScreen.navigateToTheToDoSection();
        loginScreen.navigateToTheSetUpCard();
    }
}
