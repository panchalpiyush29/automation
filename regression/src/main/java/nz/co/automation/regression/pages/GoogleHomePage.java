package nz.co.automation.regression.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import nz.co.automation.regression.domain.Query;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Component
public class GoogleHomePage {
    public static final String CSS_SELECTOR_SEARCH = "#lst-ib";
    public static final String CSS_SELECTOR_NEXT_LINK = "#pnnext";

    public void search(Query query) {
        final SelenideElement searchBox = $(CSS_SELECTOR_SEARCH);
        searchBox.sendKeys(query.getQuery());
        searchBox.pressEnter();
    }

    public boolean hasResults() {
        return $(CSS_SELECTOR_NEXT_LINK).should(Condition.appear).isDisplayed();
    }
}