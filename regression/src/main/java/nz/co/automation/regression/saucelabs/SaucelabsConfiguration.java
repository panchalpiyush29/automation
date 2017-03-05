package nz.co.automation.regression.saucelabs;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;
import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;

@Configuration
public class SaucelabsConfiguration {

    @Autowired
    SaucelabsProperties saucelabsProperties;

    @Bean(destroyMethod = "quit")
    @Scope(scopeName = "cucumber-glue", proxyMode = TARGET_CLASS)
    public RemoteWebDriver saucelabsDriver() throws MalformedURLException {

        // browser capabilities
        final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("screenResolution", saucelabsProperties.getAutomationResolution());
        capabilities.setCapability("tunnel-identifier", saucelabsProperties.getAutomationTunnel());
        capabilities.setCapability("platform", saucelabsProperties.getAutomationPlatform());

        // saucelabs
        final String saucelabsUrl = format("https://%s:%s@%s/wd/hub", saucelabsProperties.getUsername(), saucelabsProperties.getPassword(), saucelabsProperties.getDomain());
        return new RemoteWebDriver(new URL(saucelabsUrl), capabilities);
    }

}