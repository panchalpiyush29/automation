package nz.co.mobile.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;
import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;

@Configuration
public class AppiumConfiguration {

    @Autowired
    AppiumProperties appiumProperties;

    @Bean(destroyMethod = "quit")
    @Scope(scopeName = "cucumber-glue", proxyMode = TARGET_CLASS)
    public AppiumDriver appiumDriver() throws MalformedURLException {

        // appium capabilities
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", appiumProperties.getAndroidEmulatorName());
        desiredCapabilities.setCapability("platform", appiumProperties.getPlatForm());
        desiredCapabilities.setCapability("app", appiumProperties.getPath());
        desiredCapabilities.setCapability("appPackage", appiumProperties.getPackagePath());
        desiredCapabilities.setCapability("appActivity", format(".%s", appiumProperties.getActivityClass()));

        // appium
        final URL appiumUrl = new URL(format("http://%s:%s/wd/hub", appiumProperties.getHost(), appiumProperties.getPort()));
        AppiumDriver driver = new AndroidDriver(appiumUrl, desiredCapabilities);

        // configure appium
        driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);

        return driver;
    }
}
