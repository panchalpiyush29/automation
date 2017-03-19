package nz.co.mobile.domain;

import nz.co.mobile.io.PropertiesHandler;

import java.util.Properties;

public class RunConfiguration {

    private Boolean androidRun;
    private String appPath;
    private String androidEmulatorName;
    private final String CONFIG_PROPERTY_FILE = "properties/config.properties";

    private Properties configProperties = new PropertiesHandler(CONFIG_PROPERTY_FILE).getProperties();

    public RunConfiguration() {
        setAndroidRun();
        setAppPath();
        setAndroidEmulatorName();
    }

    public void setAndroidRun() {
        this.androidRun = true;
    }

    public void setAppPath() {
        appPath = configProperties.getProperty("appPath");
    }

    public void setAndroidEmulatorName() {
        androidEmulatorName = configProperties.getProperty("androidEmulatorName");
    }

    public Boolean getAndroidRun() {

        return androidRun;
    }

    public String getAppPath() {
        return appPath;
    }

    public String getAndroidEmulatorName() {
        return androidEmulatorName;
    }

}
