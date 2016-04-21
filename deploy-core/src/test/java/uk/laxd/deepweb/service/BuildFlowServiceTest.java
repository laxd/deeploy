package uk.laxd.deepweb.service;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.laxd.deepweb.model.BuildFlow;
import uk.laxd.deepweb.model.BuildFlowStep;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lawrence on 25/02/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class BuildFlowServiceTest {

    @Mock
    private Dao<BuildFlow, Long> buildFlowDao;

    @InjectMocks
    private BuildFlowService buildFlowService = new BuildFlowServiceImpl();

    @Test
    public void testFindById() throws Exception {
        buildFlowService.findById(1L);

        verify(buildFlowDao).queryForId(1L);
    }

    @Test
    public void testFindByIdExceptionNotPropogated() throws Exception {
        when(buildFlowDao.queryForId(1L)).thenThrow(new SQLException());

        BuildFlow buildFlow = buildFlowService.findById(1L);

        verify(buildFlowDao).queryForId(1L);
        assertNull(buildFlow);
    }

    @Test
    public void testFindAll() throws Exception {
        buildFlowService.findAll();

        verify(buildFlowDao).queryForAll();
    }

    @Test
    public void testFindAllExceptionNotPropogated() throws Exception {
        when(buildFlowDao.queryForAll()).thenThrow(new SQLException());

        List<BuildFlow> buildFlows = buildFlowService.findAll();

        verify(buildFlowDao).queryForAll();
        assertEquals(0, buildFlows.size());
    }
}
