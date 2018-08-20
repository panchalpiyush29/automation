package nz.co.automation.regression.pages;

import com.codeborne.selenide.Condition;
import nz.co.automation.regression.domain.SignUpDetails;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Component
public class SignUpPage {

    private static final String ID_FIRST_NAME = "firstName";
    private static final String ID_LAST_NAME = "lastName";
    private static final String ID_USERNAME = "username";
    private static final String NAME_PASSWORD = "Passwd";
    private static final String NAME_CONFIRM_PASSWORD = "ConfirmPasswd";
    private static final String ID_NEXT_BUTTON = "accountDetailsNext";
    private final String googleSignUpUrl;
    private final Browser browser;

    @Autowired
    public SignUpPage(
            @Value("${google.signup.url}") String googleSignUpUrl,
            Browser browser) {
        this.googleSignUpUrl = googleSignUpUrl;
        this.browser = browser;

    }

    public void fillForm(SignUpDetails signUpDetails) {
        browser.navigateToUrl(googleSignUpUrl);

        $(By.id(ID_FIRST_NAME)).waitUntil(Condition.visible, 10).sendKeys(signUpDetails.getFirstName());

        $(By.id(ID_LAST_NAME)).waitUntil(Condition.visible, 5).sendKeys(signUpDetails.getLastName());

        $(By.id(ID_USERNAME)).waitUntil(Condition.visible, 5).sendKeys(signUpDetails.getUserName());

        $(By.name(NAME_PASSWORD)).waitUntil(Condition.visible, 5).sendKeys(signUpDetails.getPassword());

        $(By.name(NAME_CONFIRM_PASSWORD)).waitUntil(Condition.visible, 5).sendKeys(signUpDetails.getConfirmPassword());

        $(By.id(ID_NEXT_BUTTON)).click();

    }
}
