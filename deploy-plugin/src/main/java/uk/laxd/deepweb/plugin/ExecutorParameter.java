package uk.laxd.deepweb.plugin;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by lawrence on 26/02/16.
 */
public class ExecutorParameter {

    private String name;

    private String displayName;

    private boolean mandatory;

    public ExecutorParameter(String name) {
        this(name, toDisplayName(name));
    }

    public ExecutorParameter(String name, String displayName) {
        this(name, displayName, true);
    }

    public ExecutorParameter(String name, boolean mandatory) {
        this(name, toDisplayName(name), mandatory);
    }

    public ExecutorParameter(String name, String displayName, boolean mandatory) {
        this.name = name;
        this.displayName = displayName;
        this.mandatory = mandatory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    private static String toDisplayName(String name) {
        return Arrays.stream(name.split("_"))
        .map(ExecutorParameter::ucFirst)
        .collect(Collectors.joining(" "));
    }

    private static String ucFirst(final String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}
