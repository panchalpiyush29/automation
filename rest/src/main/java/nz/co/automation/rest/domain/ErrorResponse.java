package nz.co.automation.rest.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ErrorResponse {

  private String reason;
  private List<String> errorMessages;

  @JsonCreator
  public ErrorResponse(
          @JsonProperty("reason")
                  String reason,

          @JsonProperty("errorMessage")
                  List<String> errorMessages) {
    this.reason = reason;
    this.errorMessages = errorMessages;
  }

  public String getReason() {
    return reason;
  }

  public List<String> getErrorMessages() {
    return errorMessages;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ErrorResponse that = (ErrorResponse) o;

    if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;
    return errorMessages != null ? errorMessages.equals(that.errorMessages) : that.errorMessages == null;

  }

  @Override
  public int hashCode() {
    int result = reason != null ? reason.hashCode() : 0;
    result = 31 * result + (errorMessages != null ? errorMessages.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("ErrorResponse{");
    sb.append("reason='").append(reason).append('\'');
    sb.append(", errorMessages=").append(errorMessages);
    sb.append('}');
    return sb.toString();
  }
}
