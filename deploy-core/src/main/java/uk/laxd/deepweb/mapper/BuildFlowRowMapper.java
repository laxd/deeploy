package uk.laxd.deepweb.mapper;

import org.springframework.jdbc.core.RowMapper;
import uk.laxd.deepweb.lang.Constants;
import uk.laxd.deepweb.model.BuildFlow;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lawrence on 16/02/16.
 */
public class BuildFlowRowMapper implements RowMapper<BuildFlow> {
    public BuildFlow mapRow(ResultSet resultSet, int i) throws SQLException {
        BuildFlow buildFlow = new BuildFlow();

        buildFlow.setId(resultSet.getLong(Constants.DB.ID_COLUMN));
        buildFlow.setName(resultSet.getString(Constants.DB.BuildFlow.NAME_COLUMN));

        return buildFlow;
    }
}
