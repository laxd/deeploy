package uk.laxd.deepweb.service;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.laxd.deepweb.lang.Constants;
import uk.laxd.deepweb.model.BuildFlowStep;
import uk.laxd.deepweb.model.BuildFlowStepArgument;
import uk.laxd.deepweb.model.ExecutorArgument;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lawrence on 26/02/16.
 */
@Service
public class ExecutorArgumentValidatorServiceImpl implements ExecutorArgumentValidatorService {

    @Autowired
    private Dao<ExecutorArgument, Long> executorArgumentDao;

    @Autowired
    private Dao<BuildFlowStepArgument, Long> buildFlowStepArgumentDao;

    @Override
    public void validateArguments(BuildFlowStep buildFlowStep) {
        try {
            List<ExecutorArgument> arguments = executorArgumentDao.queryForEq(Constants.DB.ExecutorArgument.EXECUTOR_ARGUMENT_ID, buildFlowStep.getExecutorId());
            List<BuildFlowStepArgument> assignedArguments = buildFlowStepArgumentDao.queryForEq(Constants.DB.BuildFlowStepArgument.BUILD_FLOW_STEP_ID_COLUMN, buildFlowStep.getId());

            for(ExecutorArgument argument : arguments) {
                if(argument.isMandatory()) {
                    // Check we have an argument value for this argument
                    QueryBuilder<BuildFlowStepArgument, Long> queryBuilder = buildFlowStepArgumentDao.queryBuilder();
                    Where<BuildFlowStepArgument, Long> where = queryBuilder.where();

                    where.idEq(buildFlowStep.getId());
                    where.eq(Constants.DB.BuildFlowStepArgument.EXECUTOR_ARGUMENT_ID_COLUMN, argument.getId());

                    BuildFlowStepArgument buildFlowStepArgument = queryBuilder.queryForFirst();

                    if(buildFlowStepArgument == null) {
                        // Couldn't find mandatory argument!
                        // TODO: Throw exception?
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
