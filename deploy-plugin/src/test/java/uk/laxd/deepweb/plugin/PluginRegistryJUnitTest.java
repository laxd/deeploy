package uk.laxd.deepweb.plugin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lawrence on 14/04/16.
 */
public class PluginRegistryJUnitTest {

    private static final String PLUGIN_NAME = "Plugin Name";

    private PluginRegistry pluginRegistry;

    @Before
    public void setUp() throws Exception {
        pluginRegistry = new PluginRegistry();
    }

    @Test
    public void testAnAddedPluginCanBeRetrievedByName() throws Exception {
        Executor executor = new Executor();
        executor.setName(PLUGIN_NAME);

        PluginDefinition pluginDefinition = new PluginDefinition(executor);

        pluginRegistry.registerExecutor(pluginDefinition);

        assertEquals(pluginDefinition, pluginRegistry.getPlugin(PLUGIN_NAME));
    }
}
