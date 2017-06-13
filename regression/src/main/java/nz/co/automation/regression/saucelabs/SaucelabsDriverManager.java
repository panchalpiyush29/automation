package nz.co.automation.regression.saucelabs;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;

@Component
public class SaucelabsDriverManager {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final SaucelabsProperties saucelabsProperties;
    private RemoteWebDriver saucelabsDriver;

    @Autowired
    public SaucelabsDriverManager(SaucelabsProperties saucelabsProperties) {
        this.saucelabsProperties = saucelabsProperties;
    }

    public RemoteWebDriver getSauceLabsDriver() {
        if (saucelabsDriver == null) {
            try {
                saucelabsDriver = createSaucelabsDriver();
            } catch (MalformedURLException e) {
                log.error("Failed to create saucelabs driver!", e);
            }
        }
        return saucelabsDriver;
    }

    private RemoteWebDriver createSaucelabsDriver() throws MalformedURLException {

        // browser capabilities
        final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("screenResolution", saucelabsProperties.getAutomationResolution());
        capabilities.setCapability("tunnel-identifier", saucelabsProperties.getAutomationTunnel());
        capabilities.setCapability("platform", saucelabsProperties.getAutomationPlatform());

        if (StringUtils.isNotBlank(saucelabsProperties.getBrowserName()) &&
                StringUtils.isNotBlank(saucelabsProperties.getBrowserVersion())) {
            capabilities.setCapability("browserName", saucelabsProperties.getBrowserName());
            capabilities.setCapability("version", saucelabsProperties.getBrowserVersion());
        }

        // saucelabs
        final String saucelabsUrl = format("https://%s:%s@%s/wd/hub", saucelabsProperties.getUsername(), saucelabsProperties.getPassword(), saucelabsProperties.getDomain());
        return new RemoteWebDriver(new URL(saucelabsUrl), capabilities);
    }
}
