package uk.laxd.deepweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.laxd.deepweb.dao.BuildFlowStepArgumentDao;
import uk.laxd.deepweb.model.BuildFlowStepArgument;

import java.util.List;

/**
 * Created by lawrence on 24/02/16.
 */
@Service
public class BuildFlowStepArgumentServiceImpl implements BuildFlowStepArgumentService {

    @Autowired
    private BuildFlowStepArgumentDao buildFlowStepArgumentDao;

    public BuildFlowStepArgument findById(Long id) {
        return buildFlowStepArgumentDao.findById(id);
    }

    public List<BuildFlowStepArgument> findByBuildFlowStepId(Long id) {
        return buildFlowStepArgumentDao.findByBuildFlowStepId(id);
    }
}
