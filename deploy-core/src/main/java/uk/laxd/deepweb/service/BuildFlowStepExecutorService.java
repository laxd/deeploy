package uk.laxd.deepweb.service;

import uk.laxd.deepweb.model.BuildFlowStep;
import uk.laxd.deepweb.executor.ExecutionResult;
import uk.laxd.deepweb.executor.ExecutorDefinition;

import java.util.Collection;

/**
 * Created by lawrence on 24/02/16.
 */
public interface BuildFlowStepExecutorService {

    ExecutionResult execute(BuildFlowStep buildFlowStep);

    Collection<ExecutorDefinition> getExecutorDefinitions();
}
