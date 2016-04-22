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

import static org.junit.Assert.assertNotNull;
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

    private GitExecutorDefinition gitExecutorDefinition = new GitExecutorDefinition();
    private MvnExecutorDefinition mvnExecutorDefinition = new MvnExecutorDefinition();
    private SshExecutorDefinition sshExecutorDefinition = new SshExecutorDefinition();

    @Before
    public void setUp() throws Exception {
        executorDefinitionMap = new HashMap<>();

        executorDefinitionMap.put(gitExecutorDefinition.getName(), gitExecutorDefinition);
        executorDefinitionMap.put(mvnExecutorDefinition.getName(), mvnExecutorDefinition);
        executorDefinitionMap.put(sshExecutorDefinition.getName(), sshExecutorDefinition);

        when(applicationContext.getBeansOfType(ExecutorDefinition.class)).thenReturn(executorDefinitionMap);
        when(applicationContext.getBean(GitExecutorDefinition.class)).thenReturn(gitExecutorDefinition);
        when(applicationContext.getBean(MvnExecutorDefinition.class)).thenReturn(mvnExecutorDefinition);
        when(applicationContext.getBean(SshExecutorDefinition.class)).thenReturn(sshExecutorDefinition);

        executorDefinitionFactory.setApplicationContext(applicationContext);
    }

    @Test
    public void testCreateByType() throws Exception {
        ExecutorDefinition executor = executorDefinitionFactory.createExecutor(gitExecutorDefinition.getName());

        assertNotNull(executor);

        verify(applicationContext).getBean(GitExecutorDefinition.class);
    }
}