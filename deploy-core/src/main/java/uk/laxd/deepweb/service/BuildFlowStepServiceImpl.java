package uk.laxd.deepweb.service;

import com.j256.ormlite.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.laxd.deepweb.model.BuildFlow;
import uk.laxd.deepweb.model.BuildFlowStep;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lawrence on 05/04/16.
 */
@Service
public class BuildFlowStepServiceImpl implements BuildFlowStepService {

    @Autowired
    private Dao<BuildFlowStep, Long> buildFlowStepDao;

    @Override
    public BuildFlowStep findById(Long id) {
        try {
            return buildFlowStepDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<BuildFlowStep> findAll() {
        try {
            return buildFlowStepDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void create(BuildFlowStep buildFlow) {
        try {
            buildFlowStepDao.create(buildFlow);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
