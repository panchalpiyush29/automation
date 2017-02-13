package nz.co.automation.regression.pages;

import com.codeborne.selenide.Selenide;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static shiver.me.timbers.data.random.RandomStrings.someString;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Selenide.class})
public class BrowserTest {

    private Browser browser;

    @Before
    public void setUp() {
        browser = new Browser();
    }

    @Test
    public void open() {
        String url = someString();
        PowerMockito.mockStatic(Selenide.class);

        // given
        PowerMockito.doNothing().when(Selenide.class);
        Selenide.open(url);

        // when
        browser.open(url);

        // then
        PowerMockito.verifyStatic();
    }


}