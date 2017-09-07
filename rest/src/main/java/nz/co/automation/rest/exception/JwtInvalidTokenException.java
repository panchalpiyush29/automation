package nz.co.automation.rest.exception;

public class JwtInvalidTokenException extends Throwable {
  public JwtInvalidTokenException(String message) {
    super(message);
  }
}
