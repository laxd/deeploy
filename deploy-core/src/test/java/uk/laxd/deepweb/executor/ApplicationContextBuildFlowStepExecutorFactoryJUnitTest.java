package uk.laxd.deepweb.executor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created by lawrence on 25/02/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/test-context.xml")
public class ApplicationContextBuildFlowStepExecutorFactoryJUnitTest {

    @Autowired
    private ApplicationContextBuildFlowStepExecutorFactory buildFlowStepExecutorFactory;

    @Test
    public void testCreateByType() throws Exception {
        BuildFlowStepExecutorType type = BuildFlowStepExecutorType.SSH;

        BuildFlowStepExecutor executor = buildFlowStepExecutorFactory.createExecutor(type);

        assertTrue(executor instanceof SshBuildFlowStepExecutor);
    }
}