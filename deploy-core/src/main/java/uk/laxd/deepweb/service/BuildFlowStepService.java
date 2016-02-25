package uk.laxd.deepweb.service;

import uk.laxd.deepweb.lang.NotFoundException;
import uk.laxd.deepweb.model.BuildFlowStep;

import java.util.List;

/**
 * Created by lawrence on 24/02/16.
 */
public interface BuildFlowStepService {
    BuildFlowStep findById(Long id) throws NotFoundException;

    List<BuildFlowStep> findByBuildFlowId(Long id);
}
