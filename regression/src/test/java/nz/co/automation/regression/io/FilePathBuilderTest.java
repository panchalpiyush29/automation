package nz.co.automation.regression.io;

import org.junit.Before;
import org.junit.Test;

import javax.management.Query;

import static org.assertj.core.api.Assertions.assertThat;

public class FilePathBuilderTest {
    private FilePathBuilder filePathBuilder;

    @Before
    public void setUp() throws Exception {
        filePathBuilder = new FilePathBuilder();
    }

    @Test
    public void build() throws Exception {
        String type = "test";
        Class<Query> classType = Query.class;

        // when
        String path = filePathBuilder.build(type, classType, "json");

        // then
        assertThat(path).isEqualTo("data/query/test.json");
    }

}