package uk.laxd.deepweb.service;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.laxd.deepweb.model.BuildFlowStep;
import uk.laxd.deepweb.model.BuildFlowStepArgument;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by lawrence on 25/02/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/test-context.xml")
public class BuildFlowStepServiceJUnitTest {

    @Autowired
    private ConnectionSource connectionSource;

    @Autowired
    private BuildFlowStepService buildFlowStepService;

    @Before
    public void setUp() throws Exception {
        TableUtils.dropTable(connectionSource, BuildFlowStep.class, true);
        TableUtils.createTable(connectionSource, BuildFlowStep.class);

        Dao<BuildFlowStep, Long> dao = DaoManager.createDao(connectionSource, BuildFlowStep.class);

        BuildFlowStep buildFlowStep = new BuildFlowStep();
        buildFlowStep.setId(1L);
        buildFlowStep.setType("TEST");
        buildFlowStep.setBuildFlowId(123L);

        dao.create(buildFlowStep);

        BuildFlowStep buildFlowStep2 = new BuildFlowStep();
        buildFlowStep2.setId(2L);
        buildFlowStep2.setType("TEST2");
        buildFlowStep2.setBuildFlowId(123L);

        dao.create(buildFlowStep2);
    }

    @Test
    public void testFindById() throws Exception {
        BuildFlowStep buildFlowStep = buildFlowStepService.findById(1L);

        assertNotNull(buildFlowStep);
        assertEquals("TEST", buildFlowStep.getType());
    }

    @Test
    public void testFindByBuildFlowId() throws Exception {
        List<BuildFlowStep> buildFlowSteps = buildFlowStepService.findByBuildFlowId(123L);

        assertEquals(2, buildFlowSteps.size());
    }
}
