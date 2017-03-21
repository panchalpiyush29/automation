package nz.co.mobile.domain;

import nz.co.mobile.io.JsonFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class ModelFactoryImpl implements ModelFactory {

    private final JsonFileReader jsonFileReader;

    @Autowired
    public ModelFactoryImpl(JsonFileReader jsonFileReader) {
        this.jsonFileReader = jsonFileReader;
    }

    @Override
    public <T> T create(Class<T> classType, String name) {
        final String directoryPath = "data";
        return create(directoryPath, classType, name);
    }

    @Override
    public <T> T create(String directoryPath, Class<T> classType, String name) {
        return jsonFileReader.read(getPath(directoryPath, classType, name), classType);
    }

    private <T> String getPath(String directoryPath, Class<T> classType, String name) {
        return format("%s/%s/%s.json", directoryPath.toLowerCase(), classType.getSimpleName().toLowerCase(), name.toLowerCase());
    }

}
