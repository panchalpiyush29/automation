package nz.co.mobile.screen;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LoginScreen {

    private static final String ID_LOGIN_EMAIL = "email";
    private static final String ID_LOGIN_PASSWORD = "password";
    private static final String ID_SIGN_IN_BUTTON = "email_sign_in_button";
    private static final String ID_OK = "button3";

    private final AppiumDriver appiumDriver;

    @Autowired
    public LoginScreen(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
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

    public void dismissNotification() throws InterruptedException {
        while (appiumDriver.findElements(By.xpath("//*[@class='android.widget.Button'][2]")).size() > 0) {
            appiumDriver.findElement(By.xpath("//*[@class='android.widget.Button'][2]")).click();
        }
    }
    public boolean loginSuccessMsgIsDisplayed() {
        return appiumDriver.findElement(By.id(ID_OK)).isDisplayed();
    }
}