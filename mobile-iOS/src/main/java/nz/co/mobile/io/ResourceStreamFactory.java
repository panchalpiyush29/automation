package nz.co.mobile.io;

import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class ResourceStreamFactory {

    public InputStream create(String path) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
    }
}
