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

		public PluginDefinition getPlugin(String name) {
			return plugins.stream()
				.filter(def -> def.getExecutor().getName().equals(name))
				.findFirst()
				.get();
		}

    public void registerExecutor(PluginDefinition pluginDefinition) {
        plugins.add(pluginDefinition);
    }
}
