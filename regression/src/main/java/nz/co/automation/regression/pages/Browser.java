package nz.co.automation.regression.pages;

import com.codeborne.selenide.Selenide;
import org.springframework.stereotype.Component;

@Component
public class Browser {

    public void open(String url) {
        Selenide.open(url);
    }
}
