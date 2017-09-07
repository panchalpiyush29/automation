package nz.co.automation.rest.exception;

public class JwtInvalidTokenException extends RuntimeException {
  public JwtInvalidTokenException(String message) {
    super(message);
  }
}
