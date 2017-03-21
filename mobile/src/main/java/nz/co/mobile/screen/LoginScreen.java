package nz.co.mobile.screen;

import io.appium.java_client.AppiumDriver;
import nz.co.mobile.steps.TestDriver;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginScreen {

    private static final String LOGIN_EMAIL_FIELD = "email_address";
    private static final String LOGIN_PASSWORD_FIELD = "password";
    private static final String SIGN_IN_BUTTON = "email_sign_in_button";

    @Autowired
    public LoginScreen() {

    }

    public void clickForgotPasswordLink() {
        AppiumDriver appiumDriver = TestDriver.getInstance().getAppiumDriver();
        appiumDriver.findElement(By.id("forgot_password_button")).click();
    }

    public void enterEmail(String email) {
        AppiumDriver appiumDriver = TestDriver.getInstance().getAppiumDriver();
        appiumDriver.findElement(By.id(LOGIN_EMAIL_FIELD)).sendKeys(email);
    }

    public void enterPassword(String password) {
        AppiumDriver appiumDriver = TestDriver.getInstance().getAppiumDriver();
        appiumDriver.findElement(By.id(LOGIN_PASSWORD_FIELD)).sendKeys(password);

    }

    public void clickSignIn() {
        AppiumDriver appiumDriver = TestDriver.getInstance().getAppiumDriver();
        appiumDriver.findElement(By.id(SIGN_IN_BUTTON)).click();
    }

    public void skipWelcomeVideo() {
        AppiumDriver appiumDriver = TestDriver.getInstance().getAppiumDriver();
        appiumDriver.navigate().back();
    }
}
