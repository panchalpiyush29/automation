package nz.co.automation.rest.service;

import nz.co.automation.rest.domain.Dog;
import nz.co.automation.rest.exception.DogNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DogRestServiceInmemoryList implements DogRestService {

    private List<Dog> dogs = new ArrayList<Dog>();

    public DogRestServiceInmemoryList() {
        Dog dog1 = new Dog(UUID.randomUUID().toString(), "St Bernard", 1);
        Dog dog2 = new Dog(UUID.randomUUID().toString(), "Chow Chow", 2);
        dogs.add(dog1);
        dogs.add(dog2);
    }

    @Override
    public List<Dog> getDogs() {
        return dogs;
    }

    @Override
    public Dog getDog(String id) {
        for (Dog dog : dogs) {
            if (id.equals(dog.getId())) {
                return dog;
            }
        }

        throw new DogNotFoundException(id);
    }

    @Override
    public Dog createDog(String name, Integer age) {
        Dog dog = new Dog(UUID.randomUUID().toString(), name, age);
        dogs.add(dog);
        return dog;
    }

    @Override
    public void updateDogById(String id, String name, Integer age) {
        for (Dog dog : dogs) {
            if (id.equals(dog.getId())) {
                if (StringUtils.isNotBlank(name)) {
                    dog.setName(name);
                }

                if (age != null) {
                    dog.setAge(age);
                }

                return;
            }
        }

        throw new DogNotFoundException(id);
    }

    @Override
    public void deleteDog(String id) {
        for (Dog dog : dogs) {
            if (id.equals(dog.getId())) {
                dogs.remove(dog);
                return;
            }
        }

        throw new DogNotFoundException(id);
    }
}
