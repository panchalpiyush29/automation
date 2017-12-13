package nz.co.automation.regression.steps;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.masterthought.cucumber.ReportBuilder;
import nz.co.automation.regression.AutomationConfiguration;
import nz.co.automation.regression.annotations.AfterAll;
import nz.co.automation.regression.annotations.BeforeAll;
import nz.co.automation.regression.saucelabs.SaucelabsClient;
import nz.co.automation.regression.saucelabs.SaucelabsDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.junit.runner.RunWith;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.codeborne.selenide.Selenide.close;
import static org.openqa.selenium.OutputType.BYTES;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AutomationConfiguration.class)
@SpringBootTest
public class Hooks {

    private final Environment environment;
    private final SaucelabsDriverManager saucelabsDriverManager;
    private final SaucelabsClient saucelabsClient;
    private final ReportBuilder reportBuilder;

    @Autowired
    public Hooks(Environment environment, SaucelabsDriverManager saucelabsDriverManager, SaucelabsClient saucelabsClient, ReportBuilder reportBuilder) {
        this.environment = environment;
        this.saucelabsDriverManager = saucelabsDriverManager;
        this.saucelabsClient = saucelabsClient;
        this.reportBuilder = reportBuilder;
    }

    @BeforeAll
    public void beforeAllScenarios() {
        System.out.println("-------------- executing BeforeAll hook ----------------\n");
    }

    @Before
    public void beforeScenario() {
        if (isSaucelabsEnabled()) {
            WebDriverRunner.setWebDriver(saucelabsDriverManager.getSauceLabsDriver());
        }
        //WebDriverRunner.setWebDriver(WebDriverRunner.getWebDriver());
    }

    @After
    public void afterScenario(Scenario scenario) {
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
                close();
            }
        }
    }

    @AfterAll
    public void afterAllScenarios() {
        System.out.println("-------------- executing AfterAll hook ----------------\n");
        reportBuilder.generateReports();
        WebDriverRunner.closeWebDriver();
    }

    private boolean isSaucelabsEnabled() {
        final String property = environment.getProperty("saucelabs.enabled");
        return StringUtils.isNotBlank(property) && property.equals("true");
    }

}
