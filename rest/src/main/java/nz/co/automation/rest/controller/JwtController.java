package nz.co.automation.rest.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import nz.co.automation.rest.domain.LoginDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping("/api/v1/jwt")
public class JwtController {

  private final ObjectMapper objectMapper;
  private final String jwtSecret;

  @Autowired
  public JwtController(@Value("${jwt.secret:quick catch up}") String jwtSecret) {
    this.objectMapper = new ObjectMapper();
    this.jwtSecret = jwtSecret;

    // configure mapper
    objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
    objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
    objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
  }

  @RequestMapping(path = "generate", method = RequestMethod.POST, produces = TEXT_PLAIN_VALUE)
  public String generate(@RequestBody LoginDetails loginDetails) {
    Map<String, Object> claims = new HashMap<>();
    claims.put("payload", loginDetails);
    return Jwts.builder()
            .setClaims(claims)
            .signWith(SignatureAlgorithm.HS512, jwtSecret)
            .compact();
  }

  @RequestMapping(path = "parse", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
  public LoginDetails parse(String token) throws IOException {
    final Object payload = Jwts.parser()
            .setSigningKey(jwtSecret)
            .parseClaimsJws(token)
            .getBody().get("payload");
    final LinkedHashMap linkedHashMap = (LinkedHashMap) payload;
    return new LoginDetails(linkedHashMap.get("username").toString(), linkedHashMap.get("password").toString());
  }

}
