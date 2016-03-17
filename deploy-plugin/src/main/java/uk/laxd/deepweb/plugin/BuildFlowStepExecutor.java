package uk.laxd.deepweb.plugin;

import uk.laxd.deepweb.plugin.lang.InvalidArgumentsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lawrence on 24/02/16.
 */
public abstract class BuildFlowStepExecutor {

    public void configure(PluginConfiguration pluginConfiguration){
        // Default no-op
    }

    public void register(PluginRegistry pluginRegistry) {
        pluginRegistry.registerExecutor(new PluginDefinition(this.getType(), this.getClass(), this));
    }

    public String getConfigurationHtml() {
        return "<html>" +
            "<body>" +
            "<div class='modal'>" +
            "<p>This Executor has not provided any configuration options</p>" +
            "</div>" +
            "</body>" +
            "</html>";
    }

    public abstract String getType();
    // TODO: Refactor to remove ExecutorArgument/Executor
    // tables and allow Plugins to manage them instead.
    // Also, make getConfigurationHtml final and build
    // inputs from getArguments();
    
    // TODO: Implement this!
    // public abstract List<Argument> getArguments();

    public abstract ExecutionResult executeWithArguments(Map<String, String> arguments);

    public void validateArguments(Map<String, String> arguments, String... requiredArguments) {
        List<String> invalidArguments = new ArrayList<>();

        for(String requiredArgument : requiredArguments) {
            if(!arguments.containsKey(requiredArgument)) {
                invalidArguments.add(requiredArgument);
            }
        }

        if(!invalidArguments.isEmpty()) {
            throw new InvalidArgumentsException(String.format("Missing required arguments: %s", String.join(",", invalidArguments)));
        }
    }
}
