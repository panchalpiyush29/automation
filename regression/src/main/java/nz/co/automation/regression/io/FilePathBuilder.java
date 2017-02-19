package nz.co.automation.regression.io;

import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class FilePathBuilder {
    public <T> String build(String type, Class<T> classType, String fileExtension) {
        return format("data/%s/%s.%s", classType.getSimpleName().toLowerCase(), type.toLowerCase(), fileExtension.toLowerCase());
    }
}
