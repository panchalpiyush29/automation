package nz.co.automation.regression.io;

import nz.co.automation.regression.domain.Query;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.removeStart;
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

    @Test (expected = IllegalStateException.class)
    public void readCorruptList() throws Exception {
        InputStream inputStream = getInputStream("data/query/corrupt.json");

        // when
        jsonReader.readList(inputStream, Query.class);
    }

    @Test
    public void readSet() {
        InputStream inputStream = getInputStream("data/query/tests.json");

        // when
        final Set<Query> queries = jsonReader.readSet(inputStream, Query.class);

        // then
        assertThat(queries).hasSize(1);
    }

    @Test (expected = IllegalStateException.class)
    public void readCorruptSet() throws Exception {
        InputStream inputStream = getInputStream("data/query/corrupt.json");

        // when
        jsonReader.readSet(inputStream, Query.class);
    }

    @Test
    public void readRandomTextNumber() throws Exception {
        InputStream inputStream = getInputStream("data/query/test-random-text-number.json");

        // when
        Query query = jsonReader.read(inputStream, Query.class);

        // then
        assertThat(query.getQuery()).startsWith("automation");
        assertThat(StringUtils.isAlphanumeric(removeStart(query.getQuery(), "automation_"))).isTrue();
    }

    @Test
    public void readRandomText() throws Exception {
        InputStream inputStream = getInputStream("data/query/test-random-text.json");

        // when
        Query query = jsonReader.read(inputStream, Query.class);

        // then
        assertThat(query.getQuery()).startsWith("automation");
        assertThat(StringUtils.isAlpha(removeStart(query.getQuery(), "automation_"))).isTrue();
    }

    @Test
    public void readRandomNumber() throws Exception {
        InputStream inputStream = getInputStream("data/query/test-random-number.json");

        // when
        Query query = jsonReader.read(inputStream, Query.class);

        // then
        assertThat(query.getQuery()).startsWith("automation");
        assertThat(StringUtils.isNumeric(removeStart(query.getQuery(), "automation_"))).isTrue();
    }

    @Test
    public void readRandomDate() throws Exception {
        InputStream inputStream = getInputStream("data/query/test-random-date.json");

        // when
        Query query = jsonReader.read(inputStream, Query.class);

        // then
        assertThat(query.getQuery()).startsWith("automation");

        final String randomDate = removeStart(query.getQuery(), "automation_");
        final DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yyyy-HH-mm-ss");
        assertThat(DateTime.parse(randomDate, formatter)).isNotNull();
    }

    @Test
    public void readRandomEmail() throws Exception {
        InputStream inputStream = getInputStream("data/query/test-random-email.json");

        // when
        Query query = jsonReader.read(inputStream, Query.class);

        // then
        assertThat(query.getQuery()).startsWith("automation");

        final String email = removeStart(query.getQuery(), "automation_");
        assertThat(email).isNotNull();
    }

    private InputStream getInputStream(String name) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
    }
}