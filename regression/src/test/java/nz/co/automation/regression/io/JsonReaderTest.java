package nz.co.automation.regression.io;

import nz.co.automation.regression.domain.Query;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;


public class JsonReaderTest {
    private JsonReader jsonReader;

    @Before
    public void setUp() throws Exception {
        jsonReader = new JsonReader();
    }

    @Test
    public void read() throws Exception {
        InputStream inputStream = new FileReader().read("data/query/test.json");

        // when
        Query query = jsonReader.read(inputStream, Query.class);

        // then
        assertThat(query).isNotNull();
        assertThat(query.getQuery()).isEqualTo("automation");
    }

    @Test (expected = IllegalStateException.class)
    public void readCorruptJsonFile() throws Exception {
        InputStream inputStream = new FileReader().read("data/query/corrupt.json");

        // when
        Query query = jsonReader.read(inputStream, Query.class);
    }
}