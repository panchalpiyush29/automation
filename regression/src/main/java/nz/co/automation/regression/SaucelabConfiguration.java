package nz.co.automation.regression;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;
import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;

@Configuration
public class SaucelabConfiguration {

    @Value("${saucelabs.domain}")
    private String saucelabsDomain;

    @Value("${saucelabs.username}")
    private String saucelabsUserName;

    @Value("${saucelabs.password}")
    private String saucelabsPassword;

    @Value("${saucelabs.automation.tunnel}")
    private String saucelabsTunnel;

    @Value("${saucelabs.automation.resolution:1280x1024}")
    private String saucelabsResolution;

    @Value("${saucelabs.automation.platform:Windows 10}")
    private String saucelabsPlatform;

    @Bean(destroyMethod = "quit")
    @Scope(scopeName = "cucumber-glue", proxyMode = TARGET_CLASS)
    public RemoteWebDriver saucelabsDriver() throws MalformedURLException {

        // browser capabilities
        final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("screenResolution", saucelabsResolution);
        capabilities.setCapability("tunnel-identifier", saucelabsTunnel);
        capabilities.setCapability("platform", saucelabsPlatform);

        // saucelabs
        final String saucelabsUrl = format("https://%s:%s@%s/wd/hub", saucelabsUserName, saucelabsPassword, saucelabsDomain);

        final RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL(saucelabsUrl), capabilities);
        WebDriverRunner.setWebDriver(remoteWebDriver);
        return remoteWebDriver;
    }

}
