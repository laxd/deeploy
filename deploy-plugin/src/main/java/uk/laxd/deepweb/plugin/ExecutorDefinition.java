package uk.laxd.deepweb.plugin;

import java.util.*;

/**
 * Created by lawrence on 24/02/16.
 */
public abstract class ExecutorDefinition {

    private String name;
    private String displayName;
    private Collection<ExecutorParameter> arguments;

    public ExecutorDefinition(String name, String displayName, ExecutorParameter... arguments) {
        this.name = name;
        this.displayName = displayName;
        this.arguments = Arrays.asList(arguments);
    }

    public void configure(PluginConfiguration pluginConfiguration){
        // Default no-op
    }

    public abstract ExecutionResult executeWithArguments(Map<String, String> arguments);

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Collection<ExecutorParameter> getArguments() {
        return arguments;
    }
}
