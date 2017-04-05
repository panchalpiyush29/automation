package nz.co.automation.rest.service;

import nz.co.automation.rest.domain.Dog;

import java.util.List;

public interface DogRestService {

    List<Dog> getDogs();

    Dog getDog(String id);

    Dog createDog(String name, Integer age);

    void updateDogById(String id, String name, Integer age);

    void deleteDog(String id);
}
