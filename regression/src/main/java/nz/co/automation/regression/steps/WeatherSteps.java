package nz.co.automation.regression.steps;

import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherSteps {

    private final String weatherApiUrl;
    private final RestTemplate restTemplate;

    @Autowired
    public WeatherSteps(@Value("${api.weather.url}") String weatherApiUrl,
                        RestTemplate restTemplate) {

        this.weatherApiUrl = weatherApiUrl;
        this.restTemplate = restTemplate;
    }


    @When("^Customer calls the weather api for London appropriate weather detail response is sent$")
    public void customerCallsTheWeatherApiForLondonAppropriateWeatherDetailResponseIsSent() throws Throwable {
        String city = "London";

        ResponseEntity<String> response = restTemplate.getForEntity(weatherApiUrl, String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody().contains(city)).isTrue();
    }

}

