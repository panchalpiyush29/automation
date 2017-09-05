package nz.co.automation.rest.service;

import nz.co.automation.rest.domain.Dog;

import java.util.Set;

public interface DogRestService {

  Set<Dog> getDogs();

  Dog getDog(Integer id);

  Dog createDog(String name, Integer age);

  void updateDog(Integer id, String name, Integer age);

  void deleteDog(Integer id);
}
