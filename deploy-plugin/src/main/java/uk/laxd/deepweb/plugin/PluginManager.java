package uk.laxd.deepweb.plugin;

import java.util.Collection;

/**
 * Created by lawrence on 14/03/16.
 */
public interface PluginManager {

    void registerPlugins();
    void reRegisterPlugins();
    Collection<PluginDefinition> getPluginDefinitions();
    PluginDefinition getPluginDefinition(String executorName);
}
