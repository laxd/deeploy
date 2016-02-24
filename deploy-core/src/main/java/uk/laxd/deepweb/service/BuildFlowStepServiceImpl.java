package uk.laxd.deepweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.laxd.deepweb.dao.BuildFlowStepDao;
import uk.laxd.deepweb.model.BuildFlowStep;

import java.util.List;

/**
 * Created by lawrence on 24/02/16.
 */
@Service
public class BuildFlowStepServiceImpl implements BuildFlowStepService {

    @Autowired
    private BuildFlowStepDao buildFlowStepDao;

    public BuildFlowStep findById(Long id) {
        return buildFlowStepDao.findById(id);
    }

    public List<BuildFlowStep> findByBuildFlowId(Long id) {
        return buildFlowStepDao.findByBuildFlowId(id);
    }
}
