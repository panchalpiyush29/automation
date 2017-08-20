package nz.co.automation.rest.service;

import nz.co.automation.rest.domain.Dog;
import nz.co.automation.rest.exception.DogNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service("dogRestServiceJdbcTemplate")
public class DogRestServiceJdbcTemplate implements DogRestService {

  private static final String PREPARE_STATEMENT_SQL_SELECT_DOG = "select * from dogs where id = ?";
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public DogRestServiceJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
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
    // create row mapper
    RowMapper<Dog> dogRowMapper = new RowMapper<Dog>() {
      @Override
      public Dog mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Dog(resultSet.getString("id"), resultSet.getString("name"), resultSet.getInt("age"));
      }
    };

    try {
      return jdbcTemplate.queryForObject("select * from dogs where id = " + id, dogRowMapper);
    } catch (EmptyResultDataAccessException e) {
      throw new DogNotFoundException(id);
    }
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
