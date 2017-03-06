package nz.co.automation.regression.saucelabs;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.Scenario;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

import static java.lang.String.format;
import static javax.xml.bind.DatatypeConverter.printBase64Binary;

@Component
public class SaucelabsClient {

    private final SaucelabsProperties saucelabsProperties;
    private final RestTemplate restTemplate;

    @Autowired
    public SaucelabsClient(SaucelabsProperties saucelabsProperties, RestTemplate restTemplate) {
        this.saucelabsProperties = saucelabsProperties;
        this.restTemplate = restTemplate;
    }

    /**
     * We are using saucelabs api to update the job name with the scenario name. Refer to https://wiki.saucelabs.com/display/DOCS/Job+Methods#JobMethods-UpdateJob.
     * @param scenario
     */
    public void updateCurrentJob(Scenario scenario) {
        final HttpHeaders headers = buildRequestHeaders();
        final HashMap<String, Object> body = buildRequestBody(scenario);
        final HttpEntity entity = buildRequestEntity(headers, body);

        final RemoteWebDriver remoteWebDriver = getWebDriver();
        final String url = buildRequestUrl(remoteWebDriver);

        restTemplate.put(url, entity);
    }

    private HttpHeaders buildRequestHeaders() {
        final HttpHeaders headers = new HttpHeaders();
        headers.add(
                "Authorization",
                "Basic " + printBase64Binary(format("%s:%s", saucelabsProperties.getUsername(), saucelabsProperties.getPassword()).getBytes())
        );
        return headers;
    }

    private HashMap<String, Object> buildRequestBody(Scenario scenario) {
        final HashMap<String, Object> body = new HashMap();
        body.put("name", scenario.getName());
        body.put("passed", !scenario.isFailed());
        body.put("tags", scenario.getSourceTagNames());
        return body;
    }

    private HttpEntity buildRequestEntity(HttpHeaders headers, HashMap<String, Object> body) {
        return new HttpEntity(body, headers);
    }

    private RemoteWebDriver getWebDriver() {
        return (RemoteWebDriver) WebDriverRunner.getWebDriver();
    }

    private String buildRequestUrl(RemoteWebDriver remoteWebDriver) {
        return format("https://%s/rest/v1/%s/jobs/%s", saucelabsProperties.getRestDomain(), saucelabsProperties.getUsername(), remoteWebDriver.getSessionId());
    }
}
