package nz.co.automation.rest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dogs")
public class Dog {

  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "age")
  private Integer age;

  public Dog() {
  }

  public Dog(Integer id, String name, Integer age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Dog dog = (Dog) o;

    if (id != null ? !id.equals(dog.id) : dog.id != null) return false;
    if (name != null ? !name.equals(dog.name) : dog.name != null) return false;
    return age != null ? age.equals(dog.age) : dog.age == null;

  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (age != null ? age.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Dog{");
    sb.append("id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", age=").append(age);
    sb.append('}');
    return sb.toString();
  }
}
