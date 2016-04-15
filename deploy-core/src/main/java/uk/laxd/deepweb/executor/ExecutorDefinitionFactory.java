package uk.laxd.deepweb.executor;

import uk.laxd.deepweb.plugin.ExecutorDefinition;

/**
 * Created by lawrence on 25/02/16.
 */
public interface ExecutorDefinitionFactory {
    ExecutorDefinition createExecutor(String type);
}
