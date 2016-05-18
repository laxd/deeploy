package uk.laxd.deepweb.dao;

import org.springframework.data.repository.CrudRepository;
import uk.laxd.deepweb.model.BuildFlowStep;

/**
 * Created by lawrence on 18/05/16.
 */
public interface BuildFlowStepDao extends CrudRepository<BuildFlowStep, Long> {
}
