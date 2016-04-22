package uk.laxd.deepweb.service;

import com.j256.ormlite.dao.Dao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.laxd.deepweb.model.BuildFlowStep;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lawrence on 22/04/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class BuildFlowStepServiceTest {

    @Mock
    private Dao<BuildFlowStep, Long> buildFlowDao;

    @InjectMocks
    private BuildFlowStepService buildFlowStepService = new BuildFlowStepServiceImpl();

    @Test
    public void testFindById() throws Exception {
        buildFlowStepService.findById(1L);

        verify(buildFlowDao).queryForId(1L);
    }

    @Test
    public void testFindByIdExceptionNotPropogated() throws Exception {
        when(buildFlowDao.queryForId(1L)).thenThrow(new SQLException());

        BuildFlowStep buildFlowStep = buildFlowStepService.findById(1L);

        verify(buildFlowDao).queryForId(1L);
        assertNull(buildFlowStep);
    }

    @Test
    public void testFindAll() throws Exception {
        buildFlowStepService.findAll();

        verify(buildFlowDao).queryForAll();
    }

    @Test
    public void testFindAllExceptionNotPropogated() throws Exception {
        when(buildFlowDao.queryForAll()).thenThrow(new SQLException());

        List<BuildFlowStep> buildFlowSteps = buildFlowStepService.findAll();

        verify(buildFlowDao).queryForAll();
        assertEquals(0, buildFlowSteps.size());
    }

    @Test
    public void testCreate() throws Exception {
        BuildFlowStep buildFlowStep = mock(BuildFlowStep.class);
        buildFlowStepService.create(buildFlowStep);

        verify(buildFlowDao).create(buildFlowStep);
    }

    @Test
    public void testCreateExceptionNotPropogated() throws Exception {
        BuildFlowStep buildFlowStep = mock(BuildFlowStep.class);

        when(buildFlowDao.create(buildFlowStep)).thenThrow(new SQLException());

        buildFlowStepService.create(buildFlowStep);

        verify(buildFlowDao).create(buildFlowStep);
    }
}