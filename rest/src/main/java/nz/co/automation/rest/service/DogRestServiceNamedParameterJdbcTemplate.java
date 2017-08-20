package nz.co.automation.rest.service;

import nz.co.automation.rest.dao.DogRowMapper;
import nz.co.automation.rest.domain.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("dogRestServiceNamedParameterJdbcTemplate")
public class DogRestServiceNamedParameterJdbcTemplate implements DogRestService {

  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
  private final DogRowMapper dogRowMapper;

  @Autowired
  public DogRestServiceNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DogRowMapper dogRowMapper) {
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    this.dogRowMapper = dogRowMapper;
  }

  @Override
  public Set<Dog> getDogs() {
    final List<Dog> dogs = namedParameterJdbcTemplate.query("select * from dogs", dogRowMapper);
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
