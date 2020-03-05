package nz.co.automation.regression.pages;

import com.codeborne.selenide.Condition;
import nz.co.automation.regression.domain.Login;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Component
public class SPBLoginPage {


    public void enterCredentials(Login login) {
        $(By.name("username")).waitUntil(Condition.visible, 20).val(login.getUsername());
        $(By.name("password")).val(login.getPassword()).pressEnter();
        enter2ndFactor();
    }

    private void enter2ndFactor() {
        $("#otp-code-text").shouldBe(visible);
        if ($("#login-crypto-button").isDisplayed()) {
            $("#login-crypto-button").click();
        } else {
            $(By.name("otpCode")).val("0000").pressEnter();
        }
    }

    public String userGreeting() {
        return $("#user-greeting").waitUntil(Condition.visible, 20).getText();
    }
}
