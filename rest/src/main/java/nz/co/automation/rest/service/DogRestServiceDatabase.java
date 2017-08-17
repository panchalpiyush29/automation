package nz.co.automation.rest.service;

import nz.co.automation.rest.domain.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@ConditionalOnProperty(name = "dog.service.inmemory", havingValue = "false")
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
    final List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from dogs");
    return null;
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
