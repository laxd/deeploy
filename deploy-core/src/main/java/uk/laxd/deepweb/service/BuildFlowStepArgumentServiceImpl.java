package uk.laxd.deepweb.service;

import com.j256.ormlite.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.laxd.deepweb.lang.Constants;
import uk.laxd.deepweb.lang.NotFoundException;
import uk.laxd.deepweb.model.BuildFlowStepArgument;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lawrence on 24/02/16.
 */
@Service
public class BuildFlowStepArgumentServiceImpl implements BuildFlowStepArgumentService {

    @Autowired
    private Dao<BuildFlowStepArgument, Long> buildFlowStepArgumentDao;

    public BuildFlowStepArgument findById(Long id) throws NotFoundException {
        try {
            return buildFlowStepArgumentDao.queryForId(id);
        } catch (SQLException e) {
            throw new NotFoundException(e);
        }
    }

    public Map<String, String> findMapByBuildFlowStepId(Long id) {
        try {
            List<BuildFlowStepArgument> arguments = buildFlowStepArgumentDao.queryForEq(Constants.DB.BuildFlowStepArgument.BUILD_FLOW_STEP_ID_COLUMN, id);
            Map<String, String> map = new HashMap<>();

            for(BuildFlowStepArgument argument : arguments) {
                map.put(argument.getName(), argument.getValue());
            }

            return map;
        } catch (SQLException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }
}
