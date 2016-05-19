package uk.laxd.deepweb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uk.laxd.deepweb.model.BuildFlowStep;

/**
 * Created by lawrence on 18/05/16.
 */
@Repository
public interface BuildFlowStepDao extends MongoRepository<BuildFlowStep, String> {
}
