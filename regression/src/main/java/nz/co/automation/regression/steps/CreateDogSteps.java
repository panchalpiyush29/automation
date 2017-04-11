package nz.co.automation.regression.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.co.automation.regression.domain.*;
import nz.co.automation.regression.io.ModelFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateDogSteps {

    private final ModelFactory modelFactory;
    private final DogDetailsHolder dogDetailsHolder;
    private final CreateDogResponseHolder createDogResponseHolder;
    private final RestTemplate restTemplate;

    @Autowired
    public CreateDogSteps(ModelFactory modelFactory, DogDetailsHolder dogDetailsHolder, CreateDogResponseHolder createDogResponseHolder, RestTemplate restTemplate) {
        this.modelFactory = modelFactory;
        this.dogDetailsHolder = dogDetailsHolder;
        this.createDogResponseHolder = createDogResponseHolder;
        this.restTemplate = restTemplate;
    }

    @Given("^I have \"([^\"]*)\" dog details$")
    public void iHaveDogDetails(String dogDetailsType) {
        DogDetails dogDetails = modelFactory.createFromJson(dogDetailsType, DogDetails.class);
        dogDetailsHolder.set(dogDetails);
    }

    @When("^I call create dog endpoint$")
    public void iCallCreateDogEndpoint() {
        final DogDetails dogDetails = dogDetailsHolder.get();

        final HashMap<String, Object> body = new HashMap();
        body.put("name", dogDetails.getName());
        body.put("age", dogDetails.getAge());
        HttpEntity request = new HttpEntity(body);

        CreateDogResponse createDogResponse = restTemplate.postForObject("http://localhost:8089/api/v1/dogs", request, CreateDogResponse.class);
        createDogResponseHolder.set(createDogResponse);
    }

    @Then("^I should see a new dog created successfully$")
    public void iShouldSeeANewDogCreatedSuccessfully() {
        CreateDogResponse createDogResponse = createDogResponseHolder.get();
        assertThat(createDogResponse.getSuccess()).isEqualTo(RestStatus.SUCCESS);

        // TODO: Call GET to verify that the new record is created

        restTemplate.delete("http://localhost:8089/api/v1/dogs/" + createDogResponse.getId());
    }
}
