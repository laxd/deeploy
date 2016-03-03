package uk.laxd.deepweb.service;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.laxd.deepweb.model.BuildFlow;
import uk.laxd.deepweb.model.BuildFlowStep;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by lawrence on 25/02/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/test-context.xml")
public class BuildFlowServiceJUnitTest {

    @Autowired
    private ConnectionSource connectionSource;

    @Autowired
    private BuildFlowService buildFlowService;

    @Before
    public void setUp() throws Exception {
        TableUtils.dropTable(connectionSource, BuildFlow.class, true);
        TableUtils.createTable(connectionSource, BuildFlow.class);

        Dao<BuildFlow, Long> dao = DaoManager.createDao(connectionSource, BuildFlow.class);

        BuildFlow buildFlow = new BuildFlow();
        buildFlow.setName("TEST");

        dao.create(buildFlow);

        BuildFlow buildFlow2 = new BuildFlow();
        buildFlow2.setName("TEST2");

        dao.create(buildFlow2);
    }

    @Test
    public void testFindById() throws Exception {
        BuildFlow buildFlow = buildFlowService.findById(1L);

        assertNotNull(buildFlow);
        assertEquals("TEST", buildFlow.getName());
    }

    @Test
    public void testFindAll() throws Exception {
        List<BuildFlow> buildFlows = buildFlowService.findAll();

        assertNotNull(buildFlows);
        assertEquals(2, buildFlows.size());
    }
}
