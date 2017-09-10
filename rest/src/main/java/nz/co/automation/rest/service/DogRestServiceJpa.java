package nz.co.automation.rest.service;

import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import nz.co.automation.rest.dao.DogsRepository;
import nz.co.automation.rest.domain.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DogRestServiceJpa implements DogRestService {

  private final DogsRepository dogsRepository;

  @Autowired
  public DogRestServiceJpa(DogsRepository dogsRepository) {
    this.dogsRepository = dogsRepository;
  }

  @Override
  public Set<Dog> getDogs() {
    final Iterable<Dog> dogs = dogsRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
    return Sets.newLinkedHashSet(dogs);
  }

  @Override
  public Dog getDog(Integer id) {
    return dogsRepository.findOne(id);
  }

  @Override
  public Dog createDog(String name, Integer age) {
    final Dog dog = new Dog();
    dog.setName(name);
    dog.setAge(age);
    return dogsRepository.save(dog);
  }

  @Override
  public void updateDog(Integer id, String name, Integer age) {
    dogsRepository.save(new Dog(id, name, age));
  }

  @Override
  public void deleteDog(Integer id) {
    dogsRepository.delete(id);
  }
}
