package nz.co.mobile.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;

@Configuration
public class AppiumConfiguration {

    @Bean(destroyMethod = "quit")
    @Scope(scopeName = "cucumber-glue", proxyMode = TARGET_CLASS)
    public AppiumDriver appiumDriver() throws MalformedURLException {

        // appium capabilities
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("udid", "F53187ED-0068-4D64-BBAC-8A57598ED025");
        desiredCapabilities.setCapability("platform", "iOS");
        desiredCapabilities.setCapability("platformVersion", "11.2");
        desiredCapabilities.setCapability("deviceName", "iPhone 8 Plus");
        desiredCapabilities.setCapability("automationName", "XCUITest");
        desiredCapabilities.setCapability("app", "/Users/piyushpanchal/Desktop/login-app.app");
        desiredCapabilities.setCapability("bundleId", "co.nz.simpleApp.login-app");

        // appium
        AppiumDriver driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);

        // configure appium
        driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);

        return driver;
    }
}