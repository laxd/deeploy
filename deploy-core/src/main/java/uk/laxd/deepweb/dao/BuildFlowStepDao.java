package uk.laxd.deepweb.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import uk.laxd.deepweb.lang.Constants;
import uk.laxd.deepweb.mapper.BuildFlowStepRowMapper;
import uk.laxd.deepweb.model.BuildFlowStep;

import java.util.List;

/**
 * Created by lawrence on 24/02/16.
 */
public class BuildFlowStepDao extends AbstractDao<BuildFlowStep> {
    public BuildFlowStepDao(JdbcTemplate template) {
        super(template, new BuildFlowStepRowMapper(), "BUILD_FLOW_STEP");
    }

    public List<BuildFlowStep> findByBuildFlowId(Long id) {
        return findByRestrictions(new Restrictions().add(Constants.DB.BuildFlowStep.BUILD_FLOW_ID_COLUMN, Symbol.EQUALS, id));
    }
}
