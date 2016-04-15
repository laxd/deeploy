package uk.laxd.deepweb.plugin;

import uk.laxd.deepweb.plugin.lang.InvalidArgumentsException;

import java.util.*;
import java.util.stream.Collectors;

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

    public void register(PluginRegistry pluginRegistry) {
        Executor executor = new Executor();
        executor.setName(name);
        executor.setDisplayName(displayName);
        executor.setArguments(arguments);
        pluginRegistry.registerExecutor(new PluginDefinition(executor));
    }

    public abstract ExecutionResult executeWithArguments(Map<String, String> arguments);

    public void validateParameters(Map<String, String> parameters) {
        List<ExecutorParameter> invalidArguments = this.arguments.stream()
                .filter(ExecutorParameter::isMandatory)
                .filter(arg -> !parameters.containsKey(arg.getName()))
                .collect(Collectors.toList());

        if(!invalidArguments.isEmpty()) {
            throw new InvalidArgumentsException(String.format("Missing required parameters: %s", invalidArguments.stream()
                    .map(ExecutorParameter::getName)
                    .collect(Collectors.joining(", "))));
        }
    }

    public String getName() {
        return name;
    }

    public Collection<ExecutorParameter> getArguments() {
        return arguments;
    }
}
