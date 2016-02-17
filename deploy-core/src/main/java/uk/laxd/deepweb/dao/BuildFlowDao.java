package uk.laxd.deepweb.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.laxd.deepweb.mapper.BuildFlowRowMapper;
import uk.laxd.deepweb.model.BuildFlow;

/**
 * Created by lawrence on 16/02/16.
 */
@Repository
public class BuildFlowDao extends AbstractDao<BuildFlow> {
    public BuildFlowDao(JdbcTemplate template) {
        super(template, new BuildFlowRowMapper(), "BUILD_FLOW");
    }
}
