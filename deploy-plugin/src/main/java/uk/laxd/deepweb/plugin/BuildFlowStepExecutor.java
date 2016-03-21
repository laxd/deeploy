package uk.laxd.deepweb.plugin;

import uk.laxd.deepweb.plugin.lang.InvalidArgumentsException;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by lawrence on 24/02/16.
 */
public abstract class BuildFlowStepExecutor {

    private String name;
    private String displayName;
    private Collection<ExecutorArgument> arguments;

    public BuildFlowStepExecutor(String name, String displayName, ExecutorArgument... arguments) {
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

    public void validateArguments(Map<String, String> arguments) {
        List<ExecutorArgument> invalidArguments = this.arguments.stream()
                .filter(ExecutorArgument::isMandatory)
                .filter(arg -> !arguments.containsKey(arg.getName()))
                .collect(Collectors.toList());

        if(!invalidArguments.isEmpty()) {
            throw new InvalidArgumentsException(String.format("Missing required arguments: %s", invalidArguments.stream()
                    .map(ExecutorArgument::getName)
                    .collect(Collectors.joining(", "))));
        }
    }

    public String getName() {
        return name;
    }

    public Collection<ExecutorArgument> getArguments() {
        return arguments;
    }
}
