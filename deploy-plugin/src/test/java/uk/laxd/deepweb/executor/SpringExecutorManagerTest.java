package uk.laxd.deepweb.executor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by lawrence on 21/04/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class SpringExecutorManagerTest {

    private ExecutorRegistry executorRegistry;

    @InjectMocks
    private SpringExecutorManager springExecutorManager;

    @Mock
    private ApplicationContext applicationContext;

    @Mock
    private ExecutorDefinition executorDefinition;

    private Map<String, ExecutorDefinition> executors;

    @Before
    public void setUp() throws Exception {
        executorRegistry = new ExecutorRegistry();
        springExecutorManager.setExecutorRegistry(executorRegistry);
        executors = new HashMap<>();
        when(applicationContext.getBeansOfType(ExecutorDefinition.class)).thenReturn(executors);
    }

    @Test
    public void testRegisterExecutorsCallsRegisterOnEach() throws Exception {
        executors.put("A", executorDefinition);
        executors.put("B", executorDefinition);
        executors.put("C", executorDefinition);

        springExecutorManager.registerExecutors();

        assertEquals(3, springExecutorManager.getExecutorDefinitions().size());
    }

    @Test
    public void testReRegisterFlushesOldExecutors() throws Exception {
        executors.put("A", executorDefinition);
        executors.put("B", executorDefinition);
        executors.put("C", executorDefinition);

        springExecutorManager.registerExecutors();

        executors.clear();
        executors.put("D", executorDefinition);

        springExecutorManager.reRegisterExecutors();

        assertEquals(1, springExecutorManager.getExecutorDefinitions().size());
    }

    @Test
    public void testGetExecutorDelegatesToRegistry() throws Exception {
        when(executorDefinition.getName()).thenReturn("A");

        executors.put("A", executorDefinition);

        springExecutorManager.registerExecutors();

        ExecutorDefinition executorDefinition = springExecutorManager.getExecutorDefinition("A");

        assertEquals(executorRegistry.getExecutor("A"), executorDefinition);
    }
}