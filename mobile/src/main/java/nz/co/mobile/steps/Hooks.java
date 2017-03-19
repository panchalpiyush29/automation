package nz.co.mobile.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.net.MalformedURLException;

public class Hooks {

    @Before
    public void setUp() throws MalformedURLException {
        TestDriver.getInstance().setUp();
    }

    @After
    public void tearDown() {
        TestDriver.getInstance().finish();
    }
}
