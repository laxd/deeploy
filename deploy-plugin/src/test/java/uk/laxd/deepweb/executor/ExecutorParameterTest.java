package uk.laxd.deepweb.executor;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lawrence on 21/04/16.
 */
public class ExecutorParameterTest {

    public static final String DISPLAY_NAME = "Not Overridden";
    public static final String VALUE_WITH_UNDERSCORES = "TEST_VALUE";
    public static final String VALUE_WITH_UNDERSCORES_DISPLAY_NAME = "Test Value";
    public static final String VALUE_WITHOUT_UNDERSCORES = "TEST";
    public static final String VALUE_WITHOUT_UNDERSCORES_DISPLAY_NAME = "Test";

    private ExecutorParameter parameter;

    @Test
    public void testDisplayNamePopulatedCorrectly() throws Exception {
        parameter = new ExecutorParameter(VALUE_WITHOUT_UNDERSCORES);

        assertEquals(VALUE_WITHOUT_UNDERSCORES_DISPLAY_NAME, parameter.getDisplayName());
    }

    @Test
    public void testDisplayNameWithUnderscores() throws Exception {
        parameter = new ExecutorParameter(VALUE_WITH_UNDERSCORES);

        assertEquals(VALUE_WITH_UNDERSCORES_DISPLAY_NAME, parameter.getDisplayName());
    }

    @Test
    public void testDisplayNameNotOverriddenIfSpecifiedInConstructor() throws Exception {
        parameter = new ExecutorParameter(VALUE_WITH_UNDERSCORES, DISPLAY_NAME);

        assertEquals(DISPLAY_NAME, parameter.getDisplayName());
    }
}