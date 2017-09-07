package nz.co.automation.rest.service;

import nz.co.automation.rest.exception.JwtInvalidTokenException;

public interface JwtService {
  String generate(String username);

  String parse(String token) throws JwtInvalidTokenException;
}
