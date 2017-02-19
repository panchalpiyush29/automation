package nz.co.automation.regression.io;

import org.junit.Before;
import org.junit.Test;

import javax.management.Query;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonFilePathTest {
    private JsonFilePath jsonFilePath;

    @Before
    public void setUp() throws Exception {
        jsonFilePath = new JsonFilePath();
    }

    @Test
    public void build() throws Exception {
        String type = "test";
        Class<Query> classType = Query.class;

        // when
        String path = jsonFilePath.build(type, classType);

        // then
        assertThat(path).isEqualTo("data/query/test.json");
    }

}