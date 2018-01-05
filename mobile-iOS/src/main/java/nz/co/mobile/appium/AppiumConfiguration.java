package nz.co.mobile.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import nz.co.mobile.steps.BaseSteps;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;

@Configuration
public class AppiumConfiguration extends BaseSteps {

    private final String udid;
    private final String platform;
    private final String platformVersion;
    private final String deviceName;
    private final String automationName;
    private final String app;
    private final String bundleId;

    @Autowired
    public AppiumConfiguration(
            @Value("${udid}") String udid,
            @Value("${platform}") String platform,
            @Value("${platformVersion}") String platformVersion,
            @Value("${deviceName}") String deviceName,
            @Value("${automationName}") String automationName,
            @Value("${app}") String app,
            @Value("${bundleId}") String bundleId) {
        this.udid = udid;
        this.platform = platform;
        this.platformVersion = platformVersion;
        this.deviceName = deviceName;
        this.automationName = automationName;
        this.app = app;
        this.bundleId = bundleId;
    }

    @Bean(destroyMethod = "quit")
    @Scope(scopeName = "cucumber-glue", proxyMode = TARGET_CLASS)
    public AppiumDriver appiumDriver() throws MalformedURLException {

        // Appium capabilities, update the value in application.properties as per your app path and emulator name
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("udid", udid);
        desiredCapabilities.setCapability("platform", platform);
        desiredCapabilities.setCapability("platformVersion", platformVersion);
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("automationName", automationName);
        desiredCapabilities.setCapability("app", app);
        desiredCapabilities.setCapability("bundleId", bundleId);

        // appium
        AppiumDriver driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);

        // configure appium
        driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);

        return driver;
    }
}