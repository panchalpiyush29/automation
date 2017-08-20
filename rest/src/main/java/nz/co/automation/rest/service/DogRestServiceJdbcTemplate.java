package nz.co.automation.rest.service;

import nz.co.automation.rest.dao.DogRowMapper;
import nz.co.automation.rest.domain.Dog;
import nz.co.automation.rest.exception.DogNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("dogRestServiceJdbcTemplate")
public class DogRestServiceJdbcTemplate implements DogRestService {

  private static final String PREPARE_STATEMENT_SQL_SELECT_DOG = "select * from dogs where id = ?";
  private final JdbcTemplate jdbcTemplate;
  private final DogRowMapper dogRowMapper;

  @Autowired
  public DogRestServiceJdbcTemplate(JdbcTemplate jdbcTemplate, DogRowMapper dogRowMapper) {
    this.jdbcTemplate = jdbcTemplate;
    this.dogRowMapper = dogRowMapper;
  }

  @Override
  public Set<Dog> getDogs() {
    final List<Dog> dogs = jdbcTemplate.query("select * from dogs", dogRowMapper);
    return new HashSet<>(dogs);
  }

  @Override
  public Dog getDog(String id) {
    try {
      return jdbcTemplate.queryForObject("select * from dogs where id = " + id, dogRowMapper);
    } catch (EmptyResultDataAccessException e) {
      throw new DogNotFoundException(id);
    }
  }

  // TODO: throw exception on attempt to create existing dog
  @Override
  public Dog createDog(String name, Integer age) {
    // create prepared statement
    PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {
      @Override
      public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
        final PreparedStatement preparedStatement = connection.prepareStatement("insert into dogs(name, age) values(?, ?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, age);
        return preparedStatement;
      }
    };

    // key holder
    KeyHolder keyHolder = new GeneratedKeyHolder();

    // execute create
    jdbcTemplate.update(preparedStatementCreator, keyHolder);

    return new Dog(keyHolder.getKeys().get("id").toString(), name, age);
  }

  @Override
  public void updateDogById(String id, String name, Integer age) {
    // TODO: implement this
    throw new UnsupportedOperationException("Not Implemented Yet!");
  }

  @Override
  public void deleteDog(String id) {
    // TODO: implement this
    throw new UnsupportedOperationException("Not Implemented Yet!");
  }
}
