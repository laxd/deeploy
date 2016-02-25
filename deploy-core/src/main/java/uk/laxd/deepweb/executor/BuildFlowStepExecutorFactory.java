package uk.laxd.deepweb.executor;

/**
 * Created by lawrence on 25/02/16.
 */
public interface BuildFlowStepExecutorFactory {
    BuildFlowStepExecutor createExecutor(BuildFlowStepExecutorType type);
}
