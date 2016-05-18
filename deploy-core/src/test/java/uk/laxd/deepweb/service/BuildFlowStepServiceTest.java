package uk.laxd.deepweb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.laxd.deepweb.dao.BuildFlowStepDao;
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
    private BuildFlowStepDao buildFlowDao;

    @InjectMocks
    private BuildFlowStepService buildFlowStepService = new BuildFlowStepServiceImpl();

    @Test
    public void testFindById() throws Exception {
        buildFlowStepService.findById(1L);

        verify(buildFlowDao).findOne(1L);
    }

    @Test
    public void testFindAll() throws Exception {
        buildFlowStepService.findAll();

        verify(buildFlowDao).findAll();
    }

    @Test
    public void testCreate() throws Exception {
        BuildFlowStep buildFlowStep = mock(BuildFlowStep.class);
        buildFlowStepService.create(buildFlowStep);

        verify(buildFlowDao).save(buildFlowStep);
    }
}