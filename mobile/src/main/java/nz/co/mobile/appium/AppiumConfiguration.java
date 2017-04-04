package nz.co.mobile.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
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
        desiredCapabilities.setCapability("deviceName", "Nexus_5_API_22");
        desiredCapabilities.setCapability("platform", "Android");
        desiredCapabilities.setCapability("app", "com.facebook.lite");
        desiredCapabilities.setCapability("appPackage", "com.facebook.lite");
        desiredCapabilities.setCapability("appActivity", ".MainActivity");

        // appium
        AppiumDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);

        // configure appium
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.MINUTES);

        return driver;
    }
}
