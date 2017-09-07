package nz.co.automation.rest.controller;

import nz.co.automation.rest.authenticator.Authenticator;
import nz.co.automation.rest.domain.LoginDetails;
import nz.co.automation.rest.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping("/api/v1/jwt")
public class JwtController {

  private final Authenticator authenticator;
  private final JwtService jwtService;

  @Autowired
  public JwtController(Authenticator authenticator, JwtService jwtService) {
    this.authenticator = authenticator;
    this.jwtService = jwtService;
  }

  @RequestMapping(path = "generate", method = RequestMethod.POST, produces = TEXT_PLAIN_VALUE)
  public String generate(@RequestBody LoginDetails loginDetails) {
    authenticator.authenticate(loginDetails);
    return jwtService.generate(loginDetails.getUsername());
  }

  @RequestMapping(path = "parse", method = RequestMethod.POST, produces = TEXT_PLAIN_VALUE)
  public String parse(String token) throws IOException {
    return jwtService.parse(token);
  }

}
