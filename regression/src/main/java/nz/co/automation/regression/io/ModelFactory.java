package nz.co.automation.regression.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class ModelFactory {

    private final FilePathBuilder filePathBuilder;
    private final FileReader fileReader;
    private final JsonReader jsonReader;

    @Autowired
    public ModelFactory(FilePathBuilder filePathBuilder, FileReader fileReader, JsonReader jsonReader) {
        this.filePathBuilder = filePathBuilder;
        this.fileReader = fileReader;
        this.jsonReader = jsonReader;
    }

    public <T> T createFromJson(String type, Class<T> classType) {
        String path = filePathBuilder.build(type, classType, "json");
        InputStream inputStream = fileReader.read(path);
        return jsonReader.read(inputStream, classType);
    }
}
