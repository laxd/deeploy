package uk.laxd.deepweb.executor;

import java.util.Collection;

/**
 * Created by lawrence on 14/03/16.
 */
public interface ExecutorManager {

    void registerExecutors();
    void reRegisterExecutors();
    Collection<ExecutorDefinition> getExecutorDefinitions();
    ExecutorDefinition getExecutorDefinition(String executorName);
}
