package nz.co.mobile.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
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

    private final String deviceName;
    private final String platform;
    private final String app;
    private final String appPackage;
    private final String appActivity;

    @Autowired
    public AppiumConfiguration(
            @Value("${deviceName}") String deviceName,
            @Value("${platform}") String platform,
            @Value("${app}") String app,
            @Value("${appPackage}") String appPackage,
            @Value("${appActivity}") String appActivity) {
        this.deviceName = deviceName;
        this.platform = platform;
        this.app = app;
        this.appPackage = appPackage;
        this.appActivity = appActivity;
    }

    @Bean(destroyMethod = "quit")
    @Scope(scopeName = "cucumber-glue", proxyMode = TARGET_CLASS)
    public AppiumDriver appiumDriver() throws MalformedURLException {

        // appium capabilities update the values in application properties for path and device name
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("platform", platform);
        desiredCapabilities.setCapability("app", app);
        desiredCapabilities.setCapability("appPackage", appPackage);
        desiredCapabilities.setCapability("appActivity", appActivity);

        // appium
        AppiumDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);

        // configure appium
        driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);

        return driver;
    }
}