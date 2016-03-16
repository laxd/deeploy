package uk.laxd.deepweb.service;

import uk.laxd.deepweb.model.BuildFlowStep;
import uk.laxd.deepweb.plugin.ExecutionResult;
import uk.laxd.deepweb.plugin.PluginDefinition;

import java.util.Collection;

/**
 * Created by lawrence on 24/02/16.
 */
public interface BuildFlowStepExecutorService {

    ExecutionResult execute(BuildFlowStep buildFlowStep);

    Collection<PluginDefinition> getPluginDefinitions();
}
