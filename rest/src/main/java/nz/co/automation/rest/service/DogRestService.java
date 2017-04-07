package nz.co.automation.rest.service;

import nz.co.automation.rest.domain.Dog;

import java.util.Set;

public interface DogRestService {

    Set<Dog> getDogs();

    Dog getDog(String id);

    Dog createDog(String name, Integer age);

    void updateDogById(String id, String name, Integer age);

    void deleteDog(String id);
}
