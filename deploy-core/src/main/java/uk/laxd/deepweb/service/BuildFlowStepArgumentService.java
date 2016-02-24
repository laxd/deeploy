package uk.laxd.deepweb.service;

import uk.laxd.deepweb.model.BuildFlowStep;
import uk.laxd.deepweb.model.BuildFlowStepArgument;

import java.util.List;

/**
 * Created by lawrence on 24/02/16.
 */
public interface BuildFlowStepArgumentService {
    BuildFlowStepArgument findById(Long id);
    List<BuildFlowStepArgument> findByBuildFlowStepId(Long id);
}
