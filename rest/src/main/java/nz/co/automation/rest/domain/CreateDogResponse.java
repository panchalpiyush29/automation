package nz.co.automation.rest.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateDogResponse {
    private final RestStatus success;
    private final String id;

    @JsonCreator
    public CreateDogResponse(
            @JsonProperty("success") RestStatus success,
            @JsonProperty("id") String id) {
        this.success = success;
        this.id = id;
    }

    public RestStatus getSuccess() {
        return success;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreateDogResponse that = (CreateDogResponse) o;

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
        final StringBuilder sb = new StringBuilder("CreateDogResponse{");
        sb.append("success=").append(success);
        sb.append(", id='").append(id).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
