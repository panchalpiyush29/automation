package nz.co.automation.regression.saucelabs;

import nz.co.automation.regression.cryptocipher.ValueCryptoCipher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "saucelabs")
public class SaucelabsProperties {
    private final ValueCryptoCipher valueCryptoCipher;
    private String domain;
    private String username;
    private String password;
    private String automationTunnel;
    private String automationResolution;
    private String automationPlatform;
    private String restDomain;
    private String browserName;
    private String browserVersion;

    @Autowired
    public SaucelabsProperties(
            ValueCryptoCipher valueCryptoCipher
    ){
        this.valueCryptoCipher = valueCryptoCipher;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = valueCryptoCipher.decrypt(password);
    }

    public String getAutomationTunnel() {
        return automationTunnel;
    }

    public void setAutomationTunnel(String automationTunnel) {
        this.automationTunnel = automationTunnel;
    }

    public String getAutomationResolution() {
        return automationResolution;
    }

    public void setAutomationResolution(String automationResolution) {
        this.automationResolution = automationResolution;
    }

    public String getAutomationPlatform() {
        return automationPlatform;
    }

    public void setAutomationPlatform(String automationPlatform) {
        this.automationPlatform = automationPlatform;
    }

    public String getRestDomain() {
        return restDomain;
    }

    public void setRestDomain(String restDomain) {
        this.restDomain = restDomain;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }
}
