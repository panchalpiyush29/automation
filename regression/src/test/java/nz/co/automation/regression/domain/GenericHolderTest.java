package nz.co.automation.regression.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class GenericHolderTest {
    private GenericHolder<Query> genericHolder;

    @Before
    public void setUp() throws Exception {
        genericHolder = new GenericHolder<Query>();
    }

    @Test
    public void set() throws Exception {
        Query value = mock(Query.class);

        // when
        genericHolder.set(value);
        Query actual = genericHolder.get();

        // then
        assertThat(actual).isEqualTo(value);
    }

}