package uk.laxd.deepweb.plugin;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by lawrence on 14/04/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ExecutorRegistryJUnitTest {

    private static final String EXECUTOR_NAME = "Plugin Name";

    private ExecutorRegistry executorRegistry;

    @Mock
    private ExecutorDefinition executorDefinition;

    @Before
    public void setUp() throws Exception {
        executorRegistry = new ExecutorRegistry();

        when(executorDefinition.getName()).thenReturn(EXECUTOR_NAME);
    }

    @Test
    public void testAnAddedPluginCanBeRetrievedByName() throws Exception {
        executorRegistry.registerExecutor(executorDefinition);

        assertEquals(executorDefinition, executorRegistry.getExecutor(EXECUTOR_NAME));
    }
}
