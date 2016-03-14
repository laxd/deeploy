package uk.laxd.deepweb.plugin;

import java.util.*;

/**
 * Created by lawrence on 14/03/16.
 */
public class PluginRegistry {

    private Map<Class<? extends BuildFlowStepExecutor>, String> executors = new HashMap<>();

    public Collection<Class<? extends BuildFlowStepExecutor>> getExecutors() {
        return executors.keySet();
    }

    public void registerExecutor(Class<? extends BuildFlowStepExecutor> executor,
                                 String name) {
        executors.put(executor, name);
    }
}
