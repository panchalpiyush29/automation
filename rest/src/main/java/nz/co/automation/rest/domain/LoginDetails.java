package nz.co.automation.rest.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginDetails {

  private String username;
  private String password;

  @JsonCreator
  public LoginDetails(
          @JsonProperty("username")
                  String username,

          @JsonProperty("password")
                  String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    LoginDetails that = (LoginDetails) o;

    if (username != null ? !username.equals(that.username) : that.username != null) return false;
    return password != null ? password.equals(that.password) : that.password == null;

  }

  @Override
  public int hashCode() {
    int result = username != null ? username.hashCode() : 0;
    result = 31 * result + (password != null ? password.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("LoginDetails{");
    sb.append("username='").append(username).append('\'');
    sb.append(", password='").append(password).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
