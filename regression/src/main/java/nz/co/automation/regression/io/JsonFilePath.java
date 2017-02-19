package nz.co.automation.regression.io;

import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class JsonFilePath {
    public <T> String build(String type, Class<T> classType) {
        return format("data/%s/%s.json", classType.getSimpleName().toLowerCase(), type.toLowerCase());
    }
}
