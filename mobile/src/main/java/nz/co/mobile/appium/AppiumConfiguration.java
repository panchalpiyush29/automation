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

import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;

@Configuration
public class AppiumConfiguration {

    @Autowired
    AppiumProperties appiumProperties;

    @Bean(destroyMethod = "quit")
    @Scope(scopeName = "cucumber-glue", proxyMode = TARGET_CLASS)
    public AppiumDriver appiumDriver() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", appiumProperties.getAndroidEmulatorName());
        desiredCapabilities.setCapability("platform", "Android");
        desiredCapabilities.setCapability("app", appiumProperties.getPath() + "app-debug.apk");
        desiredCapabilities.setCapability("appPackage", "nz.co.spark.hellospark");
        desiredCapabilities.setCapability("appActivity", ".MainActivity");
        AppiumDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
        return driver;
    }
}
