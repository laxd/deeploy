package uk.laxd.deepweb.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.laxd.deepweb.executor.ExecutorDefinition;
import uk.laxd.deepweb.executor.ExecutorManager;
import uk.laxd.deepweb.model.BuildFlowStep;

import static org.mockito.Matchers.anyMap;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lawrence on 02/03/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class BuildFlowStepExecutorServiceImplTest {

    private static final String EXECUTOR_NAME = "Executor Name";

    @InjectMocks
    private BuildFlowStepExecutorService buildFlowStepExecutorService = new BuildFlowStepExecutorServiceImpl();

    @Mock
    private BuildFlowStepArgumentCollectionToMap collectionToMap;

    @Mock
    private ExecutorManager executorManager;

    @Mock
    private ExecutorDefinition executorDefinition;

    @Before
    public void setUp() throws Exception {
        when(executorManager.getExecutorDefinition(EXECUTOR_NAME)).thenReturn(executorDefinition);
    }

    @Test
    public void testExecutorServiceExecutesExecutor() throws Exception {
        BuildFlowStep buildFlowStep = new BuildFlowStep();
        buildFlowStep.setExecutorName(EXECUTOR_NAME);

        buildFlowStepExecutorService.execute(buildFlowStep);

        verify(executorDefinition).executeWithArguments(anyMap());
    }
}