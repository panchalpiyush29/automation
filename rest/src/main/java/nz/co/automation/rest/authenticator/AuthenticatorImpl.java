package nz.co.automation.rest.authenticator;

import nz.co.automation.rest.domain.LoginDetails;
import nz.co.automation.rest.exception.AuthenticationFailureException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AuthenticatorImpl implements Authenticator {

  private List<LoginDetails> validLoginDetails = Arrays.asList(
          new LoginDetails("nick", "quickcatchup"),
          new LoginDetails("chris", "password")
  );

  @Override
  public void authenticate(LoginDetails loginDetails) {
    if (!validLoginDetails.contains(loginDetails)) {
      throw new AuthenticationFailureException("Invalid username or password");
    }
  }
}
