package uk.laxd.deepweb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.laxd.deepweb.dao.BuildFlowDao;
import uk.laxd.deepweb.model.BuildFlow;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lawrence on 25/02/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class BuildFlowServiceTest {

    @Mock
    private BuildFlowDao buildFlowDao;

    @InjectMocks
    private BuildFlowService buildFlowService = new BuildFlowServiceImpl();

    @Test
    public void testFindById() throws Exception {
        buildFlowService.findById(1L);

        verify(buildFlowDao).findOne(1L);
    }

    @Test
    public void testFindAll() throws Exception {
        buildFlowService.findAll();

        verify(buildFlowDao).findAll();
    }
}
