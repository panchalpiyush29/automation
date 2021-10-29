package nz.co.automation.regression.pages;

import com.codeborne.selenide.Condition;
import nz.co.automation.regression.domain.SignUpDetails;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Component
public class SignUpPage {

    private static final String ID_FIRST_NAME = "firstName";
    private static final String ID_LAST_NAME = "lastName";
    private static final String ID_USERNAME = "username";
    private static final String NAME_PASSWORD = "Passwd";
    private static final String NAME_CONFIRM_PASSWORD = "ConfirmPasswd";
    private static final String ID_NEXT_BUTTON = "accountDetailsNext";
    private static final String ID_SUCCCESS_MSG = "successMsg";
    private final String googleSignUpUrl;

    @Autowired
    public SignUpPage(
            @Value("${google.signup.url}") String googleSignUpUrl
    ) {
        this.googleSignUpUrl = googleSignUpUrl;
    }

    public void fillForm(SignUpDetails signUpDetails) {
        open(googleSignUpUrl);
        fill(signUpDetails);
    }

    private void fill(SignUpDetails signUpDetails) {
        $(By.id(ID_FIRST_NAME)).shouldHave(Condition.visible).sendKeys(signUpDetails.getFirstName());
        $(By.id(ID_LAST_NAME)).shouldHave(Condition.visible).sendKeys(signUpDetails.getLastName());
        $(By.id(ID_USERNAME)).shouldHave(Condition.visible).sendKeys(signUpDetails.getUserName());
        $(By.name(NAME_PASSWORD)).shouldHave(Condition.visible).sendKeys(signUpDetails.getPassword());
        $(By.name(NAME_CONFIRM_PASSWORD)).shouldHave(Condition.visible).sendKeys(signUpDetails.getConfirmPassword());
        $(By.id(ID_NEXT_BUTTON)).click();
    }

    //Note: This step is meant to fail to view the report
    public boolean successPageIsDisplayed() {
        return $(By.id(ID_SUCCCESS_MSG)).isDisplayed();
    }
}
