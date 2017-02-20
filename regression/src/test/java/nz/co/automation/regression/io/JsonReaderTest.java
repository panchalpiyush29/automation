package nz.co.automation.regression.io;

import nz.co.automation.regression.domain.Query;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class JsonReaderTest {
    private JsonReader jsonReader;

    @Before
    public void setUp() throws Exception {
        jsonReader = new JsonReader();
    }

    @Test
    public void read() throws Exception {
        InputStream inputStream = getInputStream("data/query/test.json");

        // when
        Query query = jsonReader.read(inputStream, Query.class);

        // then
        assertThat(query.getQuery()).isEqualTo("automation");
    }

    @Test (expected = IllegalStateException.class)
    public void readCorruptJsonFile() throws Exception {
        InputStream inputStream = getInputStream("data/query/corrupt.json");

        // when
        jsonReader.read(inputStream, Query.class);
    }

    @Test
    public void readList() {
        InputStream inputStream = getInputStream("data/query/tests.json");

        // when
        final List<Query> queries = jsonReader.readList(inputStream, Query.class);

        // then
        assertThat(queries).hasSize(2);
    }

    @Test
    public void readSet() {
        InputStream inputStream = getInputStream("data/query/tests.json");

        // when
        final Set<Query> queries = jsonReader.readSet(inputStream, Query.class);

        // then
        assertThat(queries).hasSize(1);
    }

    private InputStream getInputStream(String name) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
    }
}