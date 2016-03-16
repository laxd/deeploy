package uk.laxd.deepweb.plugin;

import java.util.*;

/**
 * Created by lawrence on 14/03/16.
 */
public class PluginRegistry {

    private Collection<PluginDefinition> plugins = new ArrayList<>();

    public Collection<PluginDefinition> getPlugins() {
        return plugins;
    }

    public void registerExecutor(PluginDefinition pluginDefinition) {
        plugins.add(pluginDefinition);
    }
}
