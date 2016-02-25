package uk.laxd.deepweb.service;

import com.j256.ormlite.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.laxd.deepweb.lang.Constants;
import uk.laxd.deepweb.lang.NotFoundException;
import uk.laxd.deepweb.model.BuildFlowStep;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lawrence on 24/02/16.
 */
@Service
public class BuildFlowStepServiceImpl implements BuildFlowStepService {

    @Autowired
    private Dao<BuildFlowStep, Long> buildFlowStepDao;

    public BuildFlowStep findById(Long id) throws NotFoundException {
        try {
            return buildFlowStepDao.queryForId(id);
        } catch (SQLException e) {
            throw new NotFoundException(e);
        }
    }

    public List<BuildFlowStep> findByBuildFlowId(Long id) {
        try {
            return buildFlowStepDao.queryForEq(Constants.DB.BuildFlowStep.BUILD_FLOW_ID_COLUMN, id);
        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }
}
