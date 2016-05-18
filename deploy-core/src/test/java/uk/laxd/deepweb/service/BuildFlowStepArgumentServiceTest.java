package uk.laxd.deepweb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.laxd.deepweb.dao.BuildFlowStepArgumentDao;

import static org.mockito.Mockito.verify;

/**
 * Created by lawrence on 25/02/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class BuildFlowStepArgumentServiceTest {

    @Mock
    private BuildFlowStepArgumentDao buildFlowStepArgumentDao;

    @InjectMocks
    private BuildFlowStepArgumentService buildFlowStepArgumentService = new BuildFlowStepArgumentServiceImpl();

    @Test
    public void testFindById() throws Exception {
        buildFlowStepArgumentService.findById(1L);

        verify(buildFlowStepArgumentDao).findOne(1L);
    }
}