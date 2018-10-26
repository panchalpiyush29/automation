package nz.co.automation.regression.pages;

import com.codeborne.selenide.Selenide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Browser {

    private final String googleUrl;

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
    }
}
