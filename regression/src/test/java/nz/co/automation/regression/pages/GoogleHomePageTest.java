package nz.co.automation.regression.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import nz.co.automation.regression.domain.Query;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someString;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Selenide.class})
public class GoogleHomePageTest {
    private GoogleHomePage googleHomePage;

    @Before
    public void setUp() throws Exception {
        googleHomePage = new GoogleHomePage();
    }

    @Test
    public void search() throws Exception {
        Query query = mock(Query.class);
        String queryString = someString(5);
        PowerMockito.mockStatic(Selenide.class);
        SelenideElement searchBox = mock(SelenideElement.class);

        // given
        given(Selenide.$(GoogleHomePage.CSS_SELECTOR_SEARCH)).willReturn(searchBox);
        given(query.getQuery()).willReturn(queryString);
        doNothing().when(searchBox).sendKeys(queryString);
        given(searchBox.pressEnter()).willReturn(any(SelenideElement.class));

        // when
        googleHomePage.search(query);

        // then
        PowerMockito.verifyStatic();
        Selenide.$(GoogleHomePage.CSS_SELECTOR_SEARCH);
        then(searchBox).should().sendKeys(queryString);
        then(searchBox).should().pressEnter();
    }

}