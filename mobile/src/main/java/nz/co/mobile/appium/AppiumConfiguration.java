package nz.co.mobile.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
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
        desiredCapabilities.setCapability("deviceName", "Nexus_6_API_23");
        desiredCapabilities.setCapability("platform", "Android");
        desiredCapabilities.setCapability("app", "/Users/t967085/Downloads/20170428.apk");
        desiredCapabilities.setCapability("appPackage", "nz.co.telecom.smartphone.android");
        desiredCapabilities.setCapability("appActivity", "nz.co.telecom.smartphone.activity.ActivityWelcome");

        /*    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("udid", "F8270F6A-7A28-4016-84D2-C125CFE17E0A");
        desiredCapabilities.setCapability("XCUITest", "automationName");
        desiredCapabilities.setCapability("deviceName", "iPhone 7");
        desiredCapabilities.setCapability("platformName", "iOS");
        desiredCapabilities.setCapability("platformVersion", "10.1");
        desiredCapabilities.setCapability("app", "/Users/t967085/Downloads/SparkDevRel.ipa");
        desiredCapabilities.setCapability("bundleId", "nz.co.telecom.TNZSmartphone.beta.dev"); */


        // appium
             AppiumDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);

         //  AppiumDriver driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);

        // configure appium
        driver.manage().timeouts().implicitlyWait(2L, TimeUnit.MINUTES);

        return driver;
    }
}
