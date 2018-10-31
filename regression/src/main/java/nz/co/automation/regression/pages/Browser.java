package nz.co.automation.regression.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Dimension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Browser {

    private final String googleUrl;
    private Dimension d = new Dimension(1920, 1080);

    @Autowired
    public Browser(
            @Value("${google.url}") String googleUrl) {
        this.googleUrl = googleUrl;
    }

    public void visitBaseUrl() {
        Selenide.open(googleUrl);
    }

    public void setBrowserProperties() {
        Selenide.clearBrowserCookies();
        WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverRunner.getWebDriver().manage().window().setSize(d);
    }
}