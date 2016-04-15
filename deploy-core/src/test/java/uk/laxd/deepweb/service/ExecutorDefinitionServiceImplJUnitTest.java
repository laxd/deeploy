package uk.laxd.deepweb.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.laxd.deepweb.executor.ExecutorDefinitionFactory;
import uk.laxd.deepweb.model.BuildFlowStep;
import uk.laxd.deepweb.plugin.*;

import static org.mockito.Matchers.anyMap;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lawrence on 02/03/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ExecutorDefinitionServiceImplJUnitTest {

    @InjectMocks
    private BuildFlowStepExecutorService buildFlowStepExecutorService = new BuildFlowStepExecutorServiceImpl();

    @Mock
    private ExecutorDefinitionFactory executorDefinitionFactory;

    @Mock
    private BuildFlowStepArgumentService buildFlowStepArgumentService;

    @Mock
    private ExecutorManager executorManager;

    @Mock
    private ExecutorDefinition executorDefinition;

    @Before
    public void setUp() throws Exception {
        when(executorManager.getExecutorDefinition("Executor Name")).thenReturn(executorDefinition);
    }

    @Test
    public void testExecutorServiceExecutesExecutor() throws Exception {
        BuildFlowStep buildFlowStep = new BuildFlowStep();
        buildFlowStep.setExecutorName("Executor Name");

        buildFlowStepExecutorService.execute(buildFlowStep);

        verify(executorDefinition).executeWithArguments(anyMap());
    }
}