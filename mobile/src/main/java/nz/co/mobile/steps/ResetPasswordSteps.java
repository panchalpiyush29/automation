package nz.co.mobile.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.co.mobile.domain.UserDetails;
import nz.co.mobile.holder.UserDetailsHolder;
import nz.co.mobile.screen.LoginScreen;
import nz.co.mobile.screen.ResetPasswordScreen;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class ResetPasswordSteps {
    private final ResetPasswordScreen resetPasswordScreen;
    private final LoginScreen loginScreen;
    private final UserDetailsHolder userDetailsHolder;

    @Autowired
    public ResetPasswordSteps(ResetPasswordScreen resetPasswordScreen, LoginScreen loginScreen, UserDetailsHolder userDetailsHolder) {
        this.resetPasswordScreen = resetPasswordScreen;
        this.loginScreen = loginScreen;
        this.userDetailsHolder = userDetailsHolder;
    }

    @When("^I reset my password$")
    public void iResetMyPassword() {
        UserDetails userDetails = userDetailsHolder.get();
        loginScreen.clickForgotPasswordLink();
        resetPasswordScreen.setEmailAddress(userDetails.getEmail());
        resetPasswordScreen.clickSubmitButton();
    }

    @Then("^I can see the success message$")
    public void iCanSeeTheSuccessMessage() {
        assertThat(resetPasswordScreen.verifySuccessMessage()).isTrue();
        assertThat(resetPasswordScreen.returnToLoginScreenButtonIsDisplayed()).isTrue();
    }
}