package nz.co.automation.regression.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import nz.co.automation.regression.domain.SignUpDetails;
import nz.co.automation.regression.domain.SignUpDetailsHolder;
import nz.co.automation.regression.io.ModelFactory;
import nz.co.automation.regression.pages.SignUpPage;
import org.springframework.beans.factory.annotation.Autowired;

public class SignUpSteps {

    private final ModelFactory modelFactory;
    private SignUpDetailsHolder signUpDetailsHolder;
    private SignUpPage signUpPage;


    @Autowired
    public SignUpSteps(ModelFactory modelFactory, SignUpDetailsHolder signUpDetailsHolder, SignUpPage signUpPage) {
        this.modelFactory = modelFactory;
        this.signUpDetailsHolder = signUpDetailsHolder;
        this.signUpPage = signUpPage;
    }

    @Given("^I have a \"([^\"]*)\" user details$")
    public void iHaveAUserDetails(String signUpType) {
        SignUpDetails signUpDetails = modelFactory.createFromJson(signUpType, SignUpDetails.class);
        signUpDetailsHolder.set(signUpDetails);
    }

    @When("^I fill the google sign up form$")
    public void iFillTheGoogleSignUpForm() {
        SignUpDetails signUpDetails = signUpDetailsHolder.get();
        signUpPage.fillForm(signUpDetails);
    }
}
