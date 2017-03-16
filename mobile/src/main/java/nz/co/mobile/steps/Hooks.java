package nz.co.mobile.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {

        //Please modify deviceName(same as one in Android Studio), Path before running the test
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "Nexus_5_API_22");
        desiredCapabilities.setCapability("platform", "Android");
        desiredCapabilities.setCapability("app", "/Users/piyushpanchal/appium/app-debug.apk");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
