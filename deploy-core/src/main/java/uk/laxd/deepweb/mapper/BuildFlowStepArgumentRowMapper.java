package uk.laxd.deepweb.mapper;

import org.springframework.jdbc.core.RowMapper;
import uk.laxd.deepweb.lang.Constants;
import uk.laxd.deepweb.model.BuildFlowStepArgument;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lawrence on 24/02/16.
 */
public class BuildFlowStepArgumentRowMapper implements RowMapper<BuildFlowStepArgument> {
    public BuildFlowStepArgument mapRow(ResultSet resultSet, int i) throws SQLException {
        BuildFlowStepArgument buildFlowStepArgument = new BuildFlowStepArgument();

        buildFlowStepArgument.setId(resultSet.getLong(Constants.DB.ID_COLUMN));
        buildFlowStepArgument.setName(resultSet.getString(Constants.DB.BuildFlowStepArgument.NAME_COLUMN));
        buildFlowStepArgument.setValue(resultSet.getString(Constants.DB.BuildFlowStepArgument.VALUE_COLUMN));
        buildFlowStepArgument.setBuildFlowStepId(resultSet.getLong(Constants.DB.BuildFlowStepArgument.BUILD_FLOW_STEP_ID_COLUMN));

        return buildFlowStepArgument;
    }
}
