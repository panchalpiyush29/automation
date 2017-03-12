package nz.co.automation.rest.service;

import nz.co.automation.rest.domain.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.lang.String.format;

@Service
public class DogRestService {

    private List<Dog> dogs = new ArrayList<Dog>();

    @Autowired
    public DogRestService() {
        Dog dog1 = new Dog(UUID.randomUUID().toString(), "St Bernard", 1);
        Dog dog2 = new Dog(UUID.randomUUID().toString(), "Chow Chow", 2);
        dogs.add(dog1);
        dogs.add(dog2);
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public Dog getDog(String id) {
        for (Dog dog : dogs) {
            if (id.equals(dog.getId())) {
                return dog;
            }
        }

        throw new RuntimeException(format("Unable to find dog with id %s", id));
    }

    public Dog createDog(String name, Integer age) {
        Dog dog = new Dog(UUID.randomUUID().toString(), name, age);
        dogs.add(dog);
        return dog;
    }
}
