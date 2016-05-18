package uk.laxd.deepweb.dao;

import org.springframework.data.repository.CrudRepository;
import uk.laxd.deepweb.model.BuildFlowStepArgument;

/**
 * Created by lawrence on 18/05/16.
 */
public interface BuildFlowStepArgumentDao extends CrudRepository<BuildFlowStepArgument, Long> {
}
