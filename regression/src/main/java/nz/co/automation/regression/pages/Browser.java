package nz.co.automation.regression.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Browser {

    public void open(String url) {
        Selenide.open(url);
    }

}
