package nz.co.mobile.screen;

import io.appium.java_client.AppiumDriver;
import nz.co.mobile.steps.TestDriver;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class LoginScreen {

    private static final String LOGIN_EMAIL_FIELD = "email_address";
    private static final String LOGIN_PASSWORD_FIELD = "password";
    private static final String SIGN_IN_BUTTON = "email_sign_in_button";
    private static final String DISMISS_DIALOG = "button2";
    private static final String WELCOME_TO_SPARK_TOOLBAR = "toolbar";
    private static final String TO_DO = "TO DO";
    private static final String SET_UP_ACCESS_CARD = "Set Up Access Card";

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

    public void dismissNotification() {
        appiumDriver.findElement(By.id(DISMISS_DIALOG)).click();
    }

    public boolean isDisplayingTheWelcomeToSparkMessage() {
        return appiumDriver.findElement(By.id(WELCOME_TO_SPARK_TOOLBAR)).isDisplayed();
    }
}
