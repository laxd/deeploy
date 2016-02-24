package uk.laxd.deepweb.mapper;

import org.springframework.jdbc.core.RowMapper;
import uk.laxd.deepweb.lang.Constants;
import uk.laxd.deepweb.model.BuildFlowStep;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lawrence on 24/02/16.
 */
public class BuildFlowStepRowMapper implements RowMapper<BuildFlowStep> {
    public BuildFlowStep mapRow(ResultSet resultSet, int i) throws SQLException {
        BuildFlowStep buildFlowStep = new BuildFlowStep();

        buildFlowStep.setId(resultSet.getLong(Constants.DB.ID_COLUMN));
        buildFlowStep.setBuildFlowId(resultSet.getLong(Constants.DB.BuildFlowStep.BUILD_FLOW_ID_COLUMN));
        buildFlowStep.setType(resultSet.getString(Constants.DB.BuildFlowStep.TYPE_COLUMN));

        return buildFlowStep;
    }
}
