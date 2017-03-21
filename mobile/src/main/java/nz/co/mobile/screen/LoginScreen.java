package nz.co.mobile.screen;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginScreen {

    private static final String ID_LOGIN_EMAIL = "email_address";
    private static final String ID_LOGIN_PASSWORD = "password";
    private static final String ID_SIGN_IN_BUTTON = "email_sign_in_button";

    private final AppiumDriver appiumDriver;

    @Autowired
    public LoginScreen(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void clickForgotPasswordLink() {
        appiumDriver.findElement(By.id("forgot_password_button")).click();
    }

    public void enterEmail(String email) {
        appiumDriver.findElement(By.id(ID_LOGIN_EMAIL)).sendKeys(email);
    }

    public void enterPassword(String password) {
        appiumDriver.findElement(By.id(ID_LOGIN_PASSWORD)).sendKeys(password);

    }

    public void clickSignIn() {
        appiumDriver.findElement(By.id(ID_SIGN_IN_BUTTON)).click();
    }

    public void skipWelcomeVideo() {
        appiumDriver.navigate().back();
    }
}
