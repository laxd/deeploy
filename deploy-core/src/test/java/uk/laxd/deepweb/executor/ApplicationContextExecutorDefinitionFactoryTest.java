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

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

/**
 * Created by lawrence on 25/02/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ApplicationContextExecutorDefinitionFactoryTest {

    @Mock
    private ApplicationContext applicationContext;

    @InjectMocks
    private ApplicationContextExecutorDefinitionFactory executorDefinitionFactory;

    private Map<String, ExecutorDefinition> executorDefinitionMap;

    @Mock
    private ExecutorDefinition executorDefinition;

    @Before
    public void setUp() throws Exception {
        executorDefinitionMap = new HashMap<>();

        when(executorDefinition.getName()).thenReturn("SSH");

        when(applicationContext.getBeansOfType(ExecutorDefinition.class)).thenReturn(executorDefinitionMap);
    }

    @Test
    public void testCreateByType() throws Exception {
        executorDefinitionMap.put("SSH", executorDefinition);

        executorDefinitionFactory.setApplicationContext(applicationContext);

        String type = "SSH";

        ExecutorDefinition executor = executorDefinitionFactory.createExecutor(type);

        verify(applicationContext).getBean(any(Class.class));
    }
}