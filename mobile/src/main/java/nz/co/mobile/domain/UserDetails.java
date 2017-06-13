package nz.co.mobile.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetails {
    private final String email;
    private final String password;
    private final String cardNumber;
    private final String x;

    @JsonCreator
    public UserDetails(@JsonProperty("email") String email,
                       @JsonProperty("password") String password,
                       @JsonProperty("cardNumber") String cardNumber,
                       @JsonProperty("x") String x) {
        this.email = email;
        this.password = password;
        this.cardNumber = cardNumber;
        this.x = x;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getX() {
        return x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDetails that = (UserDetails) o;

        if (!email.equals(that.email)) return false;
        if (!password.equals(that.password)) return false;
        if (!cardNumber.equals(that.cardNumber)) return false;
        return x.equals(that.x);

    }

    @Override
    public int hashCode() {
        int result = email.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + cardNumber.hashCode();
        result = 31 * result + x.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", x='" + x + '\'' +
                '}';
    }
}
