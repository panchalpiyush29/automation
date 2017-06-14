package nz.co.mobile.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.co.mobile.domain.ModelFactory;
import nz.co.mobile.domain.UserDetails;
import nz.co.mobile.holder.UserDetailsHolder;
import nz.co.mobile.screen.HomeScreen;
import nz.co.mobile.screen.LoginScreen;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps extends BaseSteps {
    private UserDetailsHolder userDetailsHolder;
    private LoginScreen loginScreen;
    private ModelFactory modelFactory;
    private HomeScreen homescreen;

    @Autowired
    public LoginSteps(UserDetailsHolder userDetailsHolder, LoginScreen loginScreen, ModelFactory modelFactory, HomeScreen homescreen) {
        this.userDetailsHolder = userDetailsHolder;
        this.loginScreen = loginScreen;
        this.modelFactory = modelFactory;
        this.homescreen = homescreen;
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
        homescreen.allowAccess();
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

    @And("^I allow notification$")
    public void iAllowNotification() throws Throwable {
        loginScreen.clickAppleAllow();
    }

    @When("^I login as the user on iphone$")
    public void iLoginAsTheUserOnIphone() throws Throwable {
        UserDetails userDetails = userDetailsHolder.get();
        loginScreen.enterEmailOnIphone(userDetails.getEmail());
        loginScreen.enterPasswordOnIphone(userDetails.getPassword());
        loginScreen.clickSignInOnIphone();
        homescreen.allowAccessOnIphone();
    }
}
