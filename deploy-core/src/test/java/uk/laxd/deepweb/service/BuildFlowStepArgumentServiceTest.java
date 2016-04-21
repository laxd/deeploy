package uk.laxd.deepweb.service;

import com.j256.ormlite.dao.Dao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.laxd.deepweb.model.BuildFlow;
import uk.laxd.deepweb.model.BuildFlowStepArgument;

import java.sql.SQLException;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lawrence on 25/02/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class BuildFlowStepArgumentServiceTest {

    @Mock
    private Dao<BuildFlowStepArgument, Long> buildFlowStepArgumentDao;

    @InjectMocks
    private BuildFlowStepArgumentService buildFlowStepArgumentService = new BuildFlowStepArgumentServiceImpl();

    @Test
    public void testFindById() throws Exception {
        buildFlowStepArgumentService.findById(1L);

        verify(buildFlowStepArgumentDao).queryForId(1L);
    }

    @Test
    public void testFindByIdExceptionNotPropogated() throws Exception {
        when(buildFlowStepArgumentDao.queryForId(1L)).thenThrow(new SQLException());

        BuildFlowStepArgument buildFlowStepArgument = buildFlowStepArgumentService.findById(1L);

        verify(buildFlowStepArgumentDao).queryForId(1L);
        assertNull(buildFlowStepArgument);
    }
}