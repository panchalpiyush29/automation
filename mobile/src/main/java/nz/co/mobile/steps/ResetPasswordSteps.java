package nz.co.mobile.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.co.mobile.screen.LoginScreen;
import nz.co.mobile.screen.ResetPasswordScreen;
import org.springframework.beans.factory.annotation.Autowired;


public class ResetPasswordSteps extends BaseSteps {
    private ResetPasswordScreen resetPasswordScreen;
    private LoginScreen loginScreen;

    @Autowired
    public ResetPasswordSteps(ResetPasswordScreen resetPasswordScreen, LoginScreen loginScreen) {
        this.resetPasswordScreen = resetPasswordScreen;
        this.loginScreen = loginScreen;
    }


    @When("^I reset my password$")
    public void iResetMyPassword() {
        loginScreen.clickForgotPasswordLink();
        resetPasswordScreen.setEmailAddress("test@test.com");
        resetPasswordScreen.clickSubmitButton();
    }

    @Then("^I can see the success message$")
    public void iCanSeeTheSuccessMessage() {
    }
}

