package uk.laxd.deepweb.service;

import uk.laxd.deepweb.model.BuildFlowStep;

/**
 * Created by lawrence on 24/02/16.
 */
public interface BuildFlowStepExecutorService {
    void execute(BuildFlowStep buildFlowStep);
}
