package uk.laxd.deepweb.executor;

import uk.laxd.deepweb.plugin.BuildFlowStepExecutor;

/**
 * Created by lawrence on 25/02/16.
 */
public interface BuildFlowStepExecutorFactory {
    BuildFlowStepExecutor createExecutor(String type);
}
