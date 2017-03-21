package nz.co.mobile.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.co.mobile.screen.LoginScreen;
import nz.co.mobile.screen.ResetPasswordScreen;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class ResetPasswordSteps {
    private final ResetPasswordScreen resetPasswordScreen;
    private final LoginScreen loginScreen;

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
        assertThat(resetPasswordScreen.verifySuccessMessage()).isTrue();
        assertThat(resetPasswordScreen.returnToLoginScreenButtonIsDisplayed()).isTrue();
    }
}