package nz.co.automation.regression.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import nz.co.automation.regression.domain.Query;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Component
public class GoogleHomePage {
    public static final String CSS_SELECTOR_SEARCH = "#lst-ib";
    public static final String CLASS_LINK = "LC20lb";


    public void search(Query query) {
        final SelenideElement searchBox = $(CSS_SELECTOR_SEARCH);
        searchBox.sendKeys(query.getQuery());
        searchBox.pressEnter();
    }

    public ElementsCollection hasResults(int resultCount) {
        return $$(By.className(CLASS_LINK)).shouldHave(CollectionCondition.sizeGreaterThanOrEqual(resultCount));
    }


}