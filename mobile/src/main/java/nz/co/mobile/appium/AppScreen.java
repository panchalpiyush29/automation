package nz.co.mobile.appium;

import io.appium.java_client.AppiumDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppScreen {
    private final AppiumDriver appiumDriver;
    @Autowired
    public AppScreen(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void scrollDown() {
        final int screenHeight = appiumDriver.manage().window().getSize().getHeight();
        appiumDriver.swipe(0,screenHeight*4/5, 0, screenHeight*6/10, 200);
    }
    public void scrollUp() {
        final int screenHeight = appiumDriver.manage().window().getSize().getHeight();
        appiumDriver.swipe(0,screenHeight*4/5, 0, screenHeight*6/10, 200);
    }

}
