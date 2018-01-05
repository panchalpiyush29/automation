package nz.co.mobile.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks extends BaseSteps {

    private final AppiumDriver appiumDriver;

    @Autowired
    public Hooks(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
        appiumDriver.closeApp();
    }
}
