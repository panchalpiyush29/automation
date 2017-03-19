package nz.co.mobile.screen;

import io.appium.java_client.AppiumDriver;
import nz.co.mobile.steps.TestDriver;
import org.openqa.selenium.By;

public class ResetPasswordScreen {

    AppiumDriver appiumDriver = TestDriver.getInstance().getDriver();

    public void setEmailAddress(String email){
        appiumDriver.findElement(By.id("email_address")).sendKeys(email);
    }

    public void clickSubmitButton(){
        appiumDriver.findElement(By.id("button_reset_password")).click();
    }
}
