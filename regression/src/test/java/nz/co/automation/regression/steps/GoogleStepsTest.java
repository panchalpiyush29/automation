package nz.co.automation.regression.steps;

import nz.co.automation.regression.pages.Browser;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

public class GoogleStepsTest {
    private GoogleSteps googleSteps;
    private Browser browser;

    @Before
    public void setUp() throws Exception {
        browser = mock(Browser.class);
        googleSteps = new GoogleSteps(browser);
    }

    @Test
    public void iHaveASearchQuery() throws Exception {

    }

    @Test
    public void iSearchOnGoogle() throws Exception {

    }

    @Test
    public void iCanSeeTheCorrectResult() throws Exception {

    }

    @Test
    public void iAmOnGooglePage() throws Exception {
        // given
        doNothing().when(browser).open("http://www.google.co.nz");

        // when
        googleSteps.iAmOnGooglePage();

        // then
        then(browser).should().open("http://www.google.co.nz");
    }

}