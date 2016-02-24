package uk.laxd.deepweb.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import uk.laxd.deepweb.lang.Constants;
import uk.laxd.deepweb.mapper.BuildFlowStepArgumentRowMapper;
import uk.laxd.deepweb.model.BuildFlowStepArgument;

import java.util.List;

/**
 * Created by lawrence on 24/02/16.
 */
public class BuildFlowStepArgumentDao extends AbstractDao<BuildFlowStepArgument> {
    public BuildFlowStepArgumentDao(JdbcTemplate template) {
        super(template, new BuildFlowStepArgumentRowMapper(), "BUILD_FLOW_STEP_ARGUMENT");
    }

    public List<BuildFlowStepArgument> findByBuildFlowStepId(Long id) {
        return findByRestrictions(new Restrictions().add(Constants.DB.BuildFlowStepArgument.BUILD_FLOW_STEP_ID_COLUMN, Symbol.EQUALS, id));
    }
}
