package nz.co.automation.regression.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class ModelFactory {

    private final JsonFilePath jsonFilePath;
    private final FileReader fileReader;
    private final JsonReader jsonReader;

    @Autowired
    public ModelFactory(JsonFilePath jsonFilePath, FileReader fileReader, JsonReader jsonReader) {
        this.jsonFilePath = jsonFilePath;
        this.fileReader = fileReader;
        this.jsonReader = jsonReader;
    }

    public <T> T create(String type, Class<T> classType) {
        String path = jsonFilePath.build(type);
        InputStream inputStream = fileReader.read(path);
        return jsonReader.read(inputStream, classType);
    }
}
