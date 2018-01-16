package nz.co.automation.regression;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class ApiHeaderConfiguration {

    private final String apiCredentials;

    @Autowired
    public ApiHeaderConfiguration(@Value("${api.credentials}") String apiCredentials) {
        this.apiCredentials = apiCredentials;
    }

    public String headerCredentials() {
        String plainCreds = apiCredentials;
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        return new String(base64CredsBytes);
    }

    public HttpHeaders getHttpHeadersBasicAuth(String base64Creds) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Basic " + base64Creds);
        return headers;
    }

}
