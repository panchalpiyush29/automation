package nz.co.automation.rest.service;

import nz.co.automation.rest.domain.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DogRestServiceDatabase implements DogRestService {

  private static final String SELECT_DOG = "select * from dogs where id = :id";
  private final DataSource dataSource;
  private final JdbcTemplate jdbcTemplate;
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Autowired
  public DogRestServiceDatabase(DataSource dataSource) {
    this.dataSource = dataSource;
    jdbcTemplate = new JdbcTemplate(dataSource);
    namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
  }

  @Override
  public Set<Dog> getDogs() {
    // get dogs from the database
    final List<Map<String, Object>> dogMaps = jdbcTemplate.queryForList("select * from dogs");

    // transform result to a list of dog objects
    final List<Dog> dogs = dogMaps.stream().map(dogMap -> new Dog(
            dogMap.get("id").toString(),
            dogMap.get("name").toString(),
            Integer.parseInt(dogMap.get("age").toString()))).collect(Collectors.toList());

    // turn this to a set
    return new HashSet<>(dogs);
  }

  @Override
  public Dog getDog(String id) {
    return null;
  }

  @Override
  public Dog createDog(String name, Integer age) {
    return null;
  }

  @Override
  public void updateDogById(String id, String name, Integer age) {

  }

  @Override
  public void deleteDog(String id) {

  }
}
