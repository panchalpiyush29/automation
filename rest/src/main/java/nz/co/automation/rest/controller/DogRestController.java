package nz.co.automation.rest.controller;

import nz.co.automation.rest.domain.*;
import nz.co.automation.rest.service.DogRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class DogRestController {

    private DogRestService dogRestService;

    @Autowired
    public DogRestController(DogRestService dogRestService) {
        this.dogRestService = dogRestService;
    }

    @RequestMapping(path = "/api/v1/dogs", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public List<Dog> getDogs() {
        return dogRestService.getDogs();
    }

    @RequestMapping(path = "/api/v1/dogs/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public Dog getDog(@PathVariable("id") String id) {
        return dogRestService.getDog(id);
    }

    @RequestMapping(path = "/api/v1/dogs", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
    public CreateDogResponse createDog(@RequestBody CreateDogRequest createDogRequest) {
        final String name = createDogRequest.getName();
        final Integer age = createDogRequest.getAge();
        final Dog dog = dogRestService.createDog(name, age);

        return new CreateDogResponse(RestStatus.SUCCESS, dog.getId());
    }

    @RequestMapping(path = "/api/v1/dogs/{id}", method = RequestMethod.PUT, produces = APPLICATION_JSON_VALUE)
    public UpdateDogResponse updateDog(@PathVariable("id") String id, @RequestBody UpdateDogRequest updateDogRequest) {
        return null;
    }

    @RequestMapping(path = "/api/v1/dogs/{id}", method = RequestMethod.DELETE, produces = APPLICATION_JSON_VALUE)
    public DeleteDogResponse delete(@PathVariable("id") String id) {
        return null;
    }
}
