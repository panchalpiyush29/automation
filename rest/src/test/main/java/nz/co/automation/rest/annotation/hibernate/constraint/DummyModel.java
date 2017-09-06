package nz.co.automation.rest.annotation.hibernate.constraint;

import nz.co.automation.rest.annotation.NoSpecialCharacters;

public class DummyModel {

  @NoSpecialCharacters({"a", "b"})
  private String value;

  public DummyModel(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    DummyModel that = (DummyModel) o;

    return value != null ? value.equals(that.value) : that.value == null;

  }

  @Override
  public int hashCode() {
    return value != null ? value.hashCode() : 0;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("DummyModel{");
    sb.append("value='").append(value).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
