package nz.co.automation.rest.dao;

import nz.co.automation.rest.domain.Dog;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DogRowMapper implements RowMapper<Dog> {
  @Override
  public Dog mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new Dog(rs.getString("id"), rs.getString("name"), rs.getInt("age"));
  }
}
