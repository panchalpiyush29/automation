package nz.co.mobile.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.co.mobile.screen.LoginScreen;
import nz.co.mobile.screen.ResetPasswordScreen;

import static junit.framework.TestCase.assertTrue;

public class ResetPasswordSteps {

    ResetPasswordScreen resetPasswordScreen = new ResetPasswordScreen();
    LoginScreen loginScreen = new LoginScreen();


    @When("^I reset my password$")
    public void iResetMyPassword() {
        loginScreen.clickForgotPasswordLink();
        resetPasswordScreen.setEmailAddress("test@test.com");
        resetPasswordScreen.clickSubmitButton();
    }

    @Then("^I can see the success message$")
    public void iCanSeeTheSuccessMessage() {
        assertTrue(resetPasswordScreen.verifySuccessMessage());
        assertTrue(resetPasswordScreen.returnToLoginScreenButtonIsDisplayed());
    }
}