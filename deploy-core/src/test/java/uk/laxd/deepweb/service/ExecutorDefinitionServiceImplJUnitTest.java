package uk.laxd.deepweb.service;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.spring.DaoFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.laxd.deepweb.executor.ApplicationContextBuildFlowStepExecutorFactory;
import uk.laxd.deepweb.model.BuildFlowStep;
import uk.laxd.deepweb.model.BuildFlowStepArgument;
import uk.laxd.deepweb.plugin.Executor;

/**
 * Created by lawrence on 02/03/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/test-context.xml")
public class ExecutorDefinitionServiceImplJUnitTest {

    @Autowired
    private ConnectionSource connectionSource;

    @Autowired
    private BuildFlowStepExecutorService buildFlowStepExecutorService;

    @Autowired
    private ApplicationContextBuildFlowStepExecutorFactory executorFactory;

    @Before
    public void setUp() throws Exception {
        TableUtils.dropTable(connectionSource, Executor.class, true);
        TableUtils.createTable(connectionSource, Executor.class);

        TableUtils.dropTable(connectionSource, BuildFlowStepArgument.class, true);
        TableUtils.createTable(connectionSource, BuildFlowStepArgument.class);

        TableUtils.dropTable(connectionSource, BuildFlowStep.class, true);
        TableUtils.createTable(connectionSource, BuildFlowStep.class);

        Dao<Executor, Long> executorDao = DaoFactory.createDao(connectionSource, Executor.class);
        Dao<BuildFlowStep, Long> buildFlowStepDao = DaoFactory.createDao(connectionSource, BuildFlowStep.class);
        Dao<BuildFlowStepArgument, Long> buildFlowStepArgumentDao = DaoFactory.createDao(connectionSource, BuildFlowStepArgument.class);

        Executor executor = new Executor();
        executor.setName("Test Executor");
        executorDao.create(executor);

        BuildFlowStep buildFlowStep = new BuildFlowStep();
        buildFlowStep.setExecutorName("Test Executor");
        buildFlowStepDao.create(buildFlowStep);

        BuildFlowStepArgument buildFlowStepArgument1 = new BuildFlowStepArgument();
        buildFlowStepArgument1.setName("TEST_ARGUMENT_1");
        buildFlowStepArgument1.setValue("TEST_VALUE_1");
        buildFlowStepArgument1.setBuildFlowStep(buildFlowStep);
        buildFlowStepArgumentDao.create(buildFlowStepArgument1);

        BuildFlowStepArgument buildFlowStepArgument2 = new BuildFlowStepArgument();
        buildFlowStepArgument2.setName("TEST_ARGUMENT_2");
        buildFlowStepArgument2.setValue("TEST_VALUE_2");
        buildFlowStepArgument2.setBuildFlowStep(buildFlowStep);
        buildFlowStepArgumentDao.create(buildFlowStepArgument2);

        DefaultListableBeanFactory parentBeanFactory = new DefaultListableBeanFactory();

        GenericApplicationContext parentContext =
                new GenericApplicationContext(parentBeanFactory);

        parentContext.refresh();

        executorFactory.setApplicationContext(parentContext);
    }

    @Test
    public void testExecutorExecutedIsTest() throws Exception {
        BuildFlowStep buildFlowStep = DaoFactory.createDao(connectionSource, BuildFlowStep.class).queryForId(1L);

        buildFlowStepExecutorService.execute(buildFlowStep);
    }
}