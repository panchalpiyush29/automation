package nz.co.automation.regression.steps;

import nz.co.automation.regression.domain.Query;
import nz.co.automation.regression.io.JsonReader;
import nz.co.automation.regression.pages.Browser;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class GoogleStepsTest {
    private GoogleSteps googleSteps;
    private Browser browser;
    private JsonReader jsonReader;

    @Before
    public void setUp() throws Exception {
        browser = mock(Browser.class);
        jsonReader = mock(JsonReader.class);
        googleSteps = new GoogleSteps(browser, jsonReader);
    }

    @Test
    public void iHaveASearchQuery() throws Exception {
        String queryType = someString(10);
        Query query = mock(Query.class);

        // given
        given(jsonReader.read(queryType, Query.class)).willReturn(query);
        //doNothing().when(queryHolder).set(query);

        // when
        googleSteps.iHaveASearchQuery(queryType);

        // then
    }

    @Test
    public void iSearchOnGoogle() throws Exception {

    }

    @Test
    public void iShouldSeeTheCorrectResult() throws Exception {

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