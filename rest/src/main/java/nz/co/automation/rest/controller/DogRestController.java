package nz.co.automation.rest.controller;

import nz.co.automation.rest.domain.Dog;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class DogRestController {

    @RequestMapping(path = "/api/v1/dogs", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public List<Dog> getDogs() {
        Dog dog1 = new Dog("St Bernard", 1);
        Dog dog2 = new Dog("Chow Chow", 2);

        return Arrays.asList(dog1, dog2);
    }

    @RequestMapping(path = "/api/v1/dogs/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public Dog getDog(@PathVariable("id") String id) {
        return new Dog("St Bernard", 1);
    }
}
