package nz.co.mobile.screen;

import io.appium.java_client.AppiumDriver;
import nz.co.mobile.steps.TestDriver;
import org.openqa.selenium.By;

public class LoginScreen {

    AppiumDriver appiumDriver = TestDriver.getInstance().getDriver();

    public void clickForgotPasswordLink(){
        appiumDriver.findElement(By.id("forgot_password_button")).click();
    }
}
