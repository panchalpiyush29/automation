package nz.co.mobile.domain;

public interface ModelFactory {
    <T> T create(Class<T> classType, String name);

    <T> T create(String directoryPath, Class<T> classType, String name);
}
