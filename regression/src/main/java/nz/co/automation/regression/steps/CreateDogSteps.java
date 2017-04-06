package nz.co.automation.regression.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.co.automation.regression.domain.DogDetails;
import nz.co.automation.regression.domain.DogDetailsHolder;
import nz.co.automation.regression.io.ModelFactory;
import nz.co.automation.rest.domain.CreateDogResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class CreateDogSteps {

    private final ModelFactory modelFactory;
    private final DogDetailsHolder dogDetailsHolder;

    @Autowired
    public CreateDogSteps(ModelFactory modelFactory, DogDetailsHolder dogDetailsHolder) {
        this.modelFactory = modelFactory;
        this.dogDetailsHolder = dogDetailsHolder;
    }

    @Given("^I have \"([^\"]*)\" dog details$")
    public void iHaveDogDetails(String dogDetailsType) {
        DogDetails dogDetails = modelFactory.createFromJson(dogDetailsType, DogDetails.class);
        dogDetailsHolder.set(dogDetails);
    }

    @When("^I call create dog endpoint$")
    public void iCallCreateDogEndpoint() {
        final DogDetails dogDetails = dogDetailsHolder.get();

        RestTemplate restTemplate = new RestTemplate();
        final HashMap<String, Object> body = new HashMap();
        body.put("name", dogDetails.getName());
        body.put("age", dogDetails.getAge());
        HttpEntity request = new HttpEntity(body);
        restTemplate.postForObject("http://localhost:8089/api/v1/dogs", request, CreateDogResponse.class);
    }

    @Then("^I should see a new dog created successfully$")
    public void iShouldSeeANewDogCreatedSuccessfully() {

    }
}
