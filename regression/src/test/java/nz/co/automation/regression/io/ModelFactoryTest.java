package nz.co.automation.regression.io;

import nz.co.automation.regression.domain.Query;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class ModelFactoryTest {
    private ModelFactory modelFactory;
    private FilePathBuilder filePathBuilder;
    private FileReader fileReader;
    private JsonReader jsonReader;


    @Before
    public void setUp() throws Exception {
        filePathBuilder = mock(FilePathBuilder.class);
        fileReader = mock(FileReader.class);
        jsonReader = mock(JsonReader.class);
        modelFactory = new ModelFactory(filePathBuilder, fileReader, jsonReader);
    }

    @Test
    public void create() throws Exception {
        Class<Query> classType = Query.class;
        String type = someString(10);
        String path = someString(10);
        InputStream inputStream = mock(InputStream.class);
        Query expected = mock(Query.class);

        // given
        given(filePathBuilder.build(type, classType, "json")).willReturn(path);
        given(fileReader.read(path)).willReturn(inputStream);
        given(jsonReader.read(inputStream, classType)).willReturn(expected);

        // when
        Query actual = modelFactory.createFromJson(type, classType);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}