package uk.laxd.deepweb.plugin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by lawrence on 14/03/16.
 */
public class PluginRegistry {

    private static final Logger LOGGER = LoggerFactory.getLogger(PluginRegistry.class);

    private Collection<PluginDefinition> plugins = new ArrayList<>();

    public Collection<PluginDefinition> getPlugins() {
        return plugins;
    }

    public PluginDefinition getPlugin(String name) {
        LOGGER.info("Retrieving plugin '{}'", name);

        return plugins.stream()
            .filter(def -> def.getExecutor().getName().equals(name))
            .findFirst()
            .get();
    }

    public void registerExecutor(PluginDefinition pluginDefinition) {
        plugins.add(pluginDefinition);
    }
}
