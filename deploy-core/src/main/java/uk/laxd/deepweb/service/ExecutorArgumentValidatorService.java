package uk.laxd.deepweb.service;

import uk.laxd.deepweb.model.BuildFlowStep;

/**
 * Created by lawrence on 26/02/16.
 */
public interface ExecutorArgumentValidatorService {
    void validateArguments(BuildFlowStep buildFlowStep);
}
