package nz.co.automation.regression.steps;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import net.masterthought.cucumber.ReportBuilder;
import nz.co.automation.regression.AutomationConfiguration;
import nz.co.automation.regression.annotations.AfterAll;
import nz.co.automation.regression.annotations.BeforeAll;
import nz.co.automation.regression.pages.Browser;
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

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.openqa.selenium.OutputType.BYTES;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AutomationConfiguration.class)
@CucumberContextConfiguration
@SpringBootTest()
public class Hooks {

    private final Environment environment;
    private final SaucelabsDriverManager saucelabsDriverManager;
    private final SaucelabsClient saucelabsClient;
    private final ReportBuilder reportBuilder;
    private final Browser browser;
    public static final String SCENARIO_TAG_API_TEST = "@api-test";

    @Autowired
    public Hooks(Environment environment, SaucelabsDriverManager saucelabsDriverManager, SaucelabsClient saucelabsClient, ReportBuilder reportBuilder, Browser browser) {
        this.environment = environment;
        this.saucelabsDriverManager = saucelabsDriverManager;
        this.saucelabsClient = saucelabsClient;
        this.reportBuilder = reportBuilder;
        this.browser = browser;
    }

    @BeforeAll
    public void beforeAllScenarios() {
        System.out.println("-------------- executing BeforeAll hook ----------------\n");
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        boolean isApiTest = scenario.getSourceTagNames().contains(SCENARIO_TAG_API_TEST);
        if (isSaucelabsEnabled()) {
            WebDriverRunner.setWebDriver(saucelabsDriverManager.getSauceLabsDriver());
        } else if (isApiTest) {
            return;
        }
        browser.visitBaseUrl();
        browser.setBrowserProperties();
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
                scenario.attach(screenshot, "image/png", scenario.getName());

            }
        } finally {
            if (isSaucelabsEnabled()) {
                closeWebDriver();
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
