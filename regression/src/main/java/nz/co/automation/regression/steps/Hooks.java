package nz.co.automation.regression.steps;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.TakesScreenshot;

import static org.openqa.selenium.OutputType.BYTES;

public class Hooks extends BaseSteps {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final TakesScreenshot takesScreenshot = (TakesScreenshot) WebDriverRunner.getWebDriver();
            final byte[] screenshot = takesScreenshot.getScreenshotAs(BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }
}
