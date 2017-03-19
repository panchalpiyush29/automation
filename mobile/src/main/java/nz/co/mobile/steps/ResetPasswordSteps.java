package nz.co.mobile.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.co.mobile.screen.LoginScreen;
import nz.co.mobile.screen.ResetPasswordScreen;

public class ResetPasswordSteps {
    @Given("^I am a \"([^\"]*)\" user$")
    public void iAmAUser(String name) {

    }

    @When("^I reset my password$")
    public void iResetMyPassword() {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.clickForgotPasswordLink();
        ResetPasswordScreen resetPasswordScreen = new ResetPasswordScreen();
        resetPasswordScreen.setEmailAddress("test@test.com");
        resetPasswordScreen.clickSubmitButton();
    }

    @Then("^I can see the success message$")
    public void iCanSeeTheSuccessMessage() {

    }
}

