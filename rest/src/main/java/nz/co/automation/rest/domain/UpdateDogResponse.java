package nz.co.automation.rest.domain;

public class UpdateDogResponse {
  private final RestStatus success;
  private final Integer id;

  public UpdateDogResponse(RestStatus success, Integer id) {
    this.success = success;
    this.id = id;
  }

  public RestStatus getSuccess() {
    return success;
  }

  public Integer getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UpdateDogResponse that = (UpdateDogResponse) o;

    if (success != that.success) return false;
    return id != null ? id.equals(that.id) : that.id == null;

  }

  @Override
  public int hashCode() {
    int result = success != null ? success.hashCode() : 0;
    result = 31 * result + (id != null ? id.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("UpdateDogResponse{");
    sb.append("success=").append(success);
    sb.append(", id=").append(id);
    sb.append('}');
    return sb.toString();
  }
}
