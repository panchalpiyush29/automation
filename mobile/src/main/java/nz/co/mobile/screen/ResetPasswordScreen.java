package nz.co.mobile.screen;

import io.appium.java_client.AppiumDriver;
import nz.co.mobile.steps.TestDriver;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class ResetPasswordScreen {

    AppiumDriver appiumDriver = TestDriver.getInstance().getAppiumDriver();

    public void setEmailAddress(String email){
        AppiumDriver appiumDriver = TestDriver.getInstance().getAppiumDriver();
        appiumDriver.findElement(By.id("email_address")).sendKeys(email);
    }

    public void clickSubmitButton(){
        AppiumDriver appiumDriver = TestDriver.getInstance().getAppiumDriver();
        appiumDriver.findElement(By.id("button_reset_password")).click();
    }
}
