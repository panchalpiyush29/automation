package nz.co.automation.regression.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class JsonReader {
    public <T> T read(InputStream inputStream, Class<T> classType) {
        try {
            return new ObjectMapper().readValue(inputStream, classType);
        } catch (IOException e) {
            // TODO Fix this message!
            throw new IllegalStateException("Unable to read!");
        }
    }
}
