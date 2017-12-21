package nz.co.mobile.screen;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResetPasswordScreen {

    public static final String ID_RESET_PASSWORD_BUTTON = "button_reset_password";
    public static final String ID_EMAIL = "email_address";
    public static final String CLASS_SUCCESS_MSG = "reset_password_success";
    public static final String EXPECTED_SUCCESS_MSG = "You have been sent an email with instructions on how to reset your password.";
    public static final String CLASS_RETURN_TO_LOGIN_SCREEN_BUTTON = "button_reset_done";

    private final AppiumDriver appiumDriver;

    @Autowired
    public ResetPasswordScreen(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void setEmailAddress(String email) {
        appiumDriver.findElement(By.id(ID_EMAIL)).sendKeys(email);
    }

    public void clickSubmitButton() {
        appiumDriver.findElement(By.id(ID_RESET_PASSWORD_BUTTON)).click();
    }

    public boolean verifySuccessMessage() {
        appiumDriver.findElement(By.id(CLASS_SUCCESS_MSG)).isDisplayed();
        return appiumDriver.findElement(By.id(CLASS_SUCCESS_MSG)).getText().equals(EXPECTED_SUCCESS_MSG);
    }

    public boolean returnToLoginScreenButtonIsDisplayed() {
        return appiumDriver.findElement(By.id(CLASS_RETURN_TO_LOGIN_SCREEN_BUTTON)).isDisplayed();
    }
}