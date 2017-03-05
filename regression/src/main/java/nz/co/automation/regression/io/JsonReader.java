package nz.co.automation.regression.io;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.RandomGeneratorModule;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

import static java.lang.String.format;

@Component
public class JsonReader {

    private final ObjectMapper objectMapper;

    public JsonReader() {
        objectMapper = new ObjectMapper();
        RandomGeneratorModule module = new RandomGeneratorModule();
        objectMapper.registerModule(module);
    }

    public <T> T read(InputStream inputStream, Class<T> classType) {
        try {
            return objectMapper.readValue(inputStream, classType);
        } catch (IOException e) {
            throw new IllegalStateException(format("Unable to read input stream for class type %s", classType.getSimpleName()), e);
        }
    }

    public <T> List<T> readList(InputStream inputStream, Class<T> classType) {
        final JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, classType);
        try {
            return objectMapper.readValue(inputStream, javaType);
        } catch (IOException e) {
            throw new IllegalStateException(format("Unable to read input stream for class type %s", classType.getSimpleName()), e);
        }
    }

    public <T> Set<T> readSet(InputStream inputStream, Class<T> classType) {
        final JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(Set.class, classType);
        try {
            return objectMapper.readValue(inputStream, javaType);
        } catch (IOException e) {
            throw new IllegalStateException(format("Unable to read input stream for class type %s", classType.getSimpleName()), e);
        }
    }
}
