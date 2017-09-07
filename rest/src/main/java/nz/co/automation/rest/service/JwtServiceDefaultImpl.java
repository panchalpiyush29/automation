package nz.co.automation.rest.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import nz.co.automation.rest.exception.JwtInvalidTokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class JwtServiceDefaultImpl implements JwtService {

  public static final String FIELD_USERNAME = "username";
  private final String jwtSecret;

  @Autowired
  public JwtServiceDefaultImpl(@Value("${jwt.secret:quick catch up}") String jwtSecret) {
    this.jwtSecret = jwtSecret;
  }

  @Override
  public String generate(String username) {
    Map<String, Object> claims = new HashMap<>();
    claims.put(FIELD_USERNAME, username);
    return Jwts.builder()
            .setClaims(claims)
            .signWith(SignatureAlgorithm.HS512, jwtSecret)
            .compact();
  }

  @Override
  public String parse(String token) throws JwtInvalidTokenException {
    try {
      return Jwts.parser()
              .setSigningKey(jwtSecret)
              .parseClaimsJws(token)
              .getBody().get(FIELD_USERNAME).toString();
    } catch (Exception e) {
      throw new JwtInvalidTokenException("Provided token is not valid!");
    }
  }

}

