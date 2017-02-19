package nz.co.automation.regression.io;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;


public class FileReaderTest {
    private FileReader fileReader;

    @Before
    public void setUp() throws Exception {
        fileReader = new FileReader();
    }

    @Test
    public void read() throws Exception {
        String path = "data/query/test.json";

        // when
        InputStream inputStream = fileReader.read(path);

        // then
        assertThat(IOUtils.toString(inputStream)).isEqualTo("{\n" + "  \"query\": \"automation\"\n" + "}");
    }

}