package nz.co.mobile.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static java.lang.String.format;

@Component
public class JsonFileReader {

    private final ResourceStreamFactory resourceStreamFactory;
    private final ObjectMapper objectMapper;

    @Autowired
    public JsonFileReader(ResourceStreamFactory resourceStreamFactory, ObjectMapper objectMapper) {
        this.resourceStreamFactory = resourceStreamFactory;
        this.objectMapper = objectMapper;
    }

    public <T> T read(String path, Class<T> type) {
        try {
            return objectMapper.readValue(resourceStreamFactory.create(path), type);
        } catch (IOException e) {
            throw new IllegalArgumentException(
                    format("Could not deserialize file (%s) into object (%s).", path, type.getName()),
                    e
            );
        }
    }
}
