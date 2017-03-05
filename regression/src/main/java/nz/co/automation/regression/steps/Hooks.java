package nz.co.automation.regression.steps;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import nz.co.automation.regression.saucelabs.SaucelabsClient;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import static org.openqa.selenium.OutputType.BYTES;

public class Hooks extends BaseSteps {

    private final Environment environment;
    private final RemoteWebDriver saucelabsDriver;
    private final SaucelabsClient saucelabsClient;

    @Autowired
    public Hooks(Environment environment, RemoteWebDriver saucelabsDriver, SaucelabsClient saucelabsClient) {
        this.environment = environment;
        this.saucelabsDriver = saucelabsDriver;
        this.saucelabsClient = saucelabsClient;
    }

    @Before
    public void setUp() {
        if (isSaucelabsEnabled()) {
            WebDriverRunner.setWebDriver(saucelabsDriver);
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (isSaucelabsEnabled()) {
                saucelabsClient.updateCurrentJob(scenario);
            }

            if (scenario.isFailed()) {
                final TakesScreenshot takesScreenshot = (TakesScreenshot) WebDriverRunner.getWebDriver();
                final byte[] screenshot = takesScreenshot.getScreenshotAs(BYTES);
                scenario.embed(screenshot, "image/png");
            }
        } finally {
            if (isSaucelabsEnabled()) {
                saucelabsDriver.close();
            }
        }
    }

    private boolean isSaucelabsEnabled() {
        return environment.getProperty("saucelabs.enabled").equals("true");
    }
}
