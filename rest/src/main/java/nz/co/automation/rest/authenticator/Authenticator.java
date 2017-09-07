package nz.co.automation.rest.authenticator;

import nz.co.automation.rest.domain.LoginDetails;

public interface Authenticator {
  void authenticate(LoginDetails loginDetails);
}
