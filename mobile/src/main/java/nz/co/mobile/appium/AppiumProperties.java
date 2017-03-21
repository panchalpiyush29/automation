package nz.co.mobile.appium;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppiumProperties {
    private String path;
    private String androidEmulatorName;
    private String packagePath;
    private String activityClass;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAndroidEmulatorName() {
        return androidEmulatorName;
    }

    public void setAndroidEmulatorName(String androidEmulatorName) {
        this.androidEmulatorName = androidEmulatorName;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    public String getActivityClass() {
        return activityClass;
    }

    public void setActivityClass(String activityClass) {
        this.activityClass = activityClass;
    }
}
