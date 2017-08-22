package nz.co.automation.rest.service;

import nz.co.automation.rest.dao.DogsRepository;
import nz.co.automation.rest.domain.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DogRestServiceJpa implements DogRestService {

  private final DogsRepository dogsRepository;

  @Autowired
  public DogRestServiceJpa(DogsRepository dogsRepository) {
    this.dogsRepository = dogsRepository;
  }

  @Override
  public Set<Dog> getDogs() {
    final Iterable<Dog> iterable = dogsRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
    return StreamSupport.stream(iterable.spliterator(), false)
            .collect(Collectors.toSet());
  }

  @Override
  public Dog getDog(String id) {
    return dogsRepository.findOne(Integer.parseInt(id));
  }

  @Override
  public Dog createDog(String name, Integer age) {
    final Dog dog = new Dog();
    dog.setName("New Dog");
    dog.setAge(3);
    return dogsRepository.save(dog);
  }

  @Override
  public void updateDogById(String id, String name, Integer age) {
    dogsRepository.save(new Dog(id, name, age));
  }

  @Override
  public void deleteDog(String id) {
    dogsRepository.delete(Integer.parseInt(id));
  }
}
