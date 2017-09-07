package nz.co.automation.rest.annotation.aspectj;

import nz.co.automation.rest.exception.UnauthorizedAccessException;
import nz.co.automation.rest.service.JwtService;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class JwtVerifyAsjectJ {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  private HttpServletRequest httpServletRequest;
  private final JwtService jwtService;

  @Autowired
  public JwtVerifyAsjectJ(HttpServletRequest httpServletRequest, JwtService jwtService) {
    this.httpServletRequest = httpServletRequest;
    this.jwtService = jwtService;
  }

  @Before("@annotation(nz.co.automation.rest.annotation.aspectj.JwtVerify)")
  public void before(JoinPoint joinPoint) throws Throwable {
    final String authorization = httpServletRequest.getHeader("Authorization");
    if (StringUtils.isBlank(authorization)) {
      throw new UnauthorizedAccessException("Unauthorised to invoke this call!");
    }

    final String[] parts = authorization.split(" ");
    if (parts.length != 2) {
      throw new UnauthorizedAccessException("Invalid authorization header!");
    }

    final String authorizationType = parts[0];
    final String authorizationToken = parts[1];

    // verify jwt token
    final String payload = jwtService.parse(authorizationToken);

    logger.info("Authorization Type: {}, Jwt Payload: {}", authorizationType, payload);
  }
}
