package nz.co.mobile.steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import nz.co.mobile.domain.RunConfiguration;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
@Component
public class TestDriver {

    private static TestDriver instance;
    private AppiumDriver driver;
    private RunConfiguration config;
    @Autowired
    private TestDriver() {
    }

    public static TestDriver getInstance(){
        if (instance == null){
            instance = new TestDriver();
        }
        return instance;
    }

    public AppiumDriver getAppiumDriver() {
        return driver;
    }

    public void setUp() throws MalformedURLException {
        config = new RunConfiguration();
        //Please modify deviceName(same as one in Android Studio), Path before running the test
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", config.getAndroidEmulatorName());
        desiredCapabilities.setCapability("platform", "Android");
        desiredCapabilities.setCapability("app", config.getAppPath() + "app-debug.apk");
        desiredCapabilities.setCapability("appPackage", "nz.co.spark.hellospark");
        desiredCapabilities.setCapability("appActivity", ".MainActivity");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
    }

    public void finish(){
        driver.quit();
    }
}
