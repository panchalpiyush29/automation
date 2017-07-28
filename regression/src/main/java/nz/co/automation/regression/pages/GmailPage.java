package nz.co.automation.regression.pages;

import com.codeborne.selenide.Condition;
import nz.co.automation.regression.domain.Login;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Component
public class GmailPage {

    private static final String CLASS_EMAIL = "whsOnd";
    private static final String ID_NEXT = "identifierNext";
    private static final String NAME_PASSWORD = "password";
    private static final String ID_PASSWORD_NEXT = "passwordNext";
    private static final String CLASS_SEARCHBOX = "#gbqfq";


    public void enterCredentials(Login login) {
        $(By.className(CLASS_EMAIL)).sendKeys(login.getEmail());
        $(By.id(ID_NEXT)).click();
        $(By.name(NAME_PASSWORD)).sendKeys(login.getPassword());
        $(By.id(ID_PASSWORD_NEXT)).click();
    }

    public boolean loggedInUser() throws InterruptedException {
        Thread.sleep(15000);
        return $(CLASS_SEARCHBOX).waitUntil(Condition.visible, 20L).isDisplayed();
    }
}
