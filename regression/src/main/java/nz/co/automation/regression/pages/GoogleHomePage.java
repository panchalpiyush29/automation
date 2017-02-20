package nz.co.automation.regression.pages;

import com.codeborne.selenide.SelenideElement;
import nz.co.automation.regression.domain.Query;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Component
public class GoogleHomePage {
    private final String ID_SEARCH = "#lst-ib";

    public void search(Query query) {
        final SelenideElement searchBox = $(ID_SEARCH);
        searchBox.sendKeys(query.getQuery());
        searchBox.pressEnter();
    }
}