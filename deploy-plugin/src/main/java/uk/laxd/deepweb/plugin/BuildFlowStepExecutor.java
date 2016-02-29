package uk.laxd.deepweb.plugin;

import java.util.Map;

/**
 * Created by lawrence on 24/02/16.
 */
public abstract class BuildFlowStepExecutor {

    public void configure(PluginConfiguration pluginConfiguration){
        // Default no-op
    }

    public abstract String getType();

    public abstract void executeWithArguments(Map<String, String> arguments);
}
