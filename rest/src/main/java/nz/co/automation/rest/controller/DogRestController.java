package nz.co.automation.rest.controller;

import nz.co.automation.rest.annotation.aspectj.JwtVerify;
import nz.co.automation.rest.annotation.beanpostprocessor.Log;
import nz.co.automation.rest.domain.*;
import nz.co.automation.rest.service.DogRestService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/dogs")
public class DogRestController {

  @Log
  private static Logger logger;

  private DogRestService dogRestService;

  @Autowired
  public DogRestController(@Qualifier("dogRestServiceJpa") DogRestService dogRestService) {
    this.dogRestService = dogRestService;
  }

  @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
  public Set<Dog> getDogs() {
    logger.info("Get a list of dogs!");
    return dogRestService.getDogs();
  }

  @RequestMapping(path = "{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
  public Dog getDog(@PathVariable("id") Integer id) {
    return dogRestService.getDog(id);
  }

  @RequestMapping(method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
  public CreateDogResponse createDog(@Validated @RequestBody CreateDogRequest createDogRequest) {
    final String name = createDogRequest.getName();
    final Integer age = createDogRequest.getAge();
    final Dog dog = dogRestService.createDog(name, age);
    return new CreateDogResponse(RestStatus.SUCCESS, dog.getId());
  }

  @RequestMapping(path = "{id}", method = RequestMethod.PUT, produces = APPLICATION_JSON_VALUE)
  @JwtVerify
  public UpdateDogResponse updateDog(@PathVariable("id") Integer id, @RequestBody UpdateDogRequest updateDogRequest, @RequestHeader(value = "Authorization", required = false) String authorization) {
    final String name = updateDogRequest.getName();
    final Integer age = updateDogRequest.getAge();
    dogRestService.updateDog(id, name, age);
    return new UpdateDogResponse(RestStatus.SUCCESS, id);
  }

  @RequestMapping(path = "{id}", method = RequestMethod.DELETE, produces = APPLICATION_JSON_VALUE)
  @JwtVerify
  public DeleteDogResponse delete(@PathVariable("id") Integer id, @RequestHeader(value = "Authorization", required = false) String authorization) {
    dogRestService.deleteDog(id);
    return new DeleteDogResponse(RestStatus.SUCCESS, id);
  }

  public void printHelloWorld() {
    logger.info("test");
  }
}
