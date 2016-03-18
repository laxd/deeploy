package uk.laxd.deepweb.plugin;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by lawrence on 26/02/16.
 */
public class Executor {

    private String name;
    private Collection<ExecutorArgument> arguments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<ExecutorArgument> getArguments() {
        return arguments;
    }

    public void setArguments(Collection<ExecutorArgument> arguments) {
        this.arguments = arguments;
    }

    public void setArguments(ExecutorArgument... arguments) {
        this.arguments = Arrays.asList(arguments);
    }
}
