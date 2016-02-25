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
import uk.laxd.deepweb.model.BuildFlowStepArgument;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by lawrence on 25/02/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/test-context.xml")
public class BuildFlowStepArgumentServiceJUnitTest {

    @Autowired
    private ConnectionSource connectionSource;

    @Autowired
    private BuildFlowStepArgumentService buildFlowStepArgumentService;

    @Before
    public void setUp() throws Exception {
        TableUtils.dropTable(connectionSource, BuildFlowStepArgument.class, true);
        TableUtils.createTable(connectionSource, BuildFlowStepArgument.class);

        Dao<BuildFlowStepArgument, Long> dao = DaoManager.createDao(connectionSource, BuildFlowStepArgument.class);

        BuildFlowStepArgument buildFlowStepArgument = new BuildFlowStepArgument();
        buildFlowStepArgument.setId(1L);
        buildFlowStepArgument.setName("TEST");
        buildFlowStepArgument.setValue("TEST_VALUE");
        buildFlowStepArgument.setBuildFlowStepId(123L);

        dao.create(buildFlowStepArgument);

        BuildFlowStepArgument buildFlowStepArgument2 = new BuildFlowStepArgument();
        buildFlowStepArgument2.setId(2L);
        buildFlowStepArgument2.setName("TEST2");
        buildFlowStepArgument2.setValue("TEST_VALUE2");
        buildFlowStepArgument2.setBuildFlowStepId(123L);

        dao.create(buildFlowStepArgument2);
    }

    @Test
    public void testFindById() throws Exception {
        BuildFlowStepArgument buildFlowStepArgument = buildFlowStepArgumentService.findById(1L);

        assertNotNull(buildFlowStepArgument);
        assertEquals("TEST", buildFlowStepArgument.getName());
    }

    @Test
    public void testFindAll() throws Exception {
        Map<String, String> arguments = buildFlowStepArgumentService.findMapByBuildFlowStepId(123L);

        assertEquals(2, arguments.size());
        assertEquals("TEST_VALUE", arguments.get("TEST"));
        assertEquals("TEST_VALUE2", arguments.get("TEST2"));
    }
}