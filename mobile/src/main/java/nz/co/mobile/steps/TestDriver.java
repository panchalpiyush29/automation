package nz.co.mobile.steps;

import io.appium.java_client.android.AndroidDriver;
import nz.co.mobile.domain.RunConfiguration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestDriver {

    private static TestDriver instance;
    private AndroidDriver driver;
    private RunConfiguration config;

    private TestDriver() {
    }

    public static TestDriver getInstance(){
        if (instance == null){
            instance = new TestDriver();
        }
        return instance;
    }

    public void setUp() throws MalformedURLException {
        config = new RunConfiguration();
        //Please modify deviceName(same as one in Android Studio), Path before running the test
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", config.getAndroidEmulatorName());
        desiredCapabilities.setCapability("platform", "Android");
        desiredCapabilities.setCapability("app", config.getAppPath() + "app-debug.apk");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
    }

    public void finish(){
        driver.quit();
    }
}
