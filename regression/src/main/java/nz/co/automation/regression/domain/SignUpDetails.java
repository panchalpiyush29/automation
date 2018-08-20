package nz.co.automation.regression.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.RandomStringUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SignUpDetails {

    private final static String RANDOM = "$RANDOM_VALUE$";

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String confirmPassword;

    @JsonCreator
    public SignUpDetails(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("userName") String userName,
            @JsonProperty("password") String password,
            @JsonProperty("confirmPassword") String confirmPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (RANDOM.equals(userName)) {
            this.userName = buildRandomEmail();
        } else {
            this.userName = userName;
        }
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    private String buildRandomEmail() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("automationTest.+")
                .append(RandomStringUtils.randomAlphanumeric(10))
                .toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SignUpDetails)) return false;

        SignUpDetails that = (SignUpDetails) o;

        if (!getFirstName().equals(that.getFirstName())) return false;
        if (!getLastName().equals(that.getLastName())) return false;
        if (!getUserName().equals(that.getUserName())) return false;
        if (!getPassword().equals(that.getPassword())) return false;
        return getConfirmPassword().equals(that.getConfirmPassword());
    }

    @Override
    public int hashCode() {
        int result = getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getUserName().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getConfirmPassword().hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SignUpDetails{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", confirmPassword='").append(confirmPassword).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
