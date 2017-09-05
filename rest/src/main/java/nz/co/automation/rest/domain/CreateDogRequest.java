package nz.co.automation.rest.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import nz.co.automation.rest.annotation.NoSpecialCharacters;

public class CreateDogRequest {

  @NoSpecialCharacters
  private String name;
  private Integer age;

  @JsonCreator
  public CreateDogRequest(
          @JsonProperty("name") String name,
          @JsonProperty("age") Integer age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CreateDogRequest that = (CreateDogRequest) o;

    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return age != null ? age.equals(that.age) : that.age == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (age != null ? age.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("CreateDogRequest{");
    sb.append("name='").append(name).append('\'');
    sb.append(", age=").append(age);
    sb.append('}');
    return sb.toString();
  }
}
