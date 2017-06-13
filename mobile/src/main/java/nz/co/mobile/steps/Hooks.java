package nz.co.mobile.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }

        appiumDriver.closeApp();
    }
}
