package uk.laxd.deepweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.laxd.deepweb.dao.BuildFlowStepDao;
import uk.laxd.deepweb.model.BuildFlowStep;

/**
 * Created by lawrence on 05/04/16.
 */
@Service
public class BuildFlowStepServiceImpl implements BuildFlowStepService {

    @Autowired
    private BuildFlowStepDao buildFlowStepDao;

    @Override
    public BuildFlowStep findById(Long id) {
        return buildFlowStepDao.findOne(id);
    }

    @Override
    public Iterable<BuildFlowStep> findAll() {
        return buildFlowStepDao.findAll();
    }

    @Override
    public void create(BuildFlowStep buildFlow) {
        buildFlowStepDao.save(buildFlow);
    }
}
