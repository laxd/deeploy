package uk.laxd.deepweb.plugin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by lawrence on 14/03/16.
 */
@Component
@Scope("singleton")
public class SpringPluginManager implements PluginManager, ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringPluginManager.class);

    private ApplicationContext applicationContext;

    private PluginRegistry pluginRegistry = new PluginRegistry();

    @Override
    public void registerPlugins() {
        LOGGER.info("Registering executors ...");
        for(ExecutorDefinition executor : applicationContext.getBeansOfType(ExecutorDefinition.class).values()) {
            LOGGER.debug("Registering executor '{}'", executor.getName());
            executor.register(pluginRegistry);
        }

        LOGGER.info("Registered {} executors!", pluginRegistry.getPlugins().size());
    }

    @Override
    public void reRegisterPlugins() {
        pluginRegistry = new PluginRegistry();
        registerPlugins();
    }

    @Override
    public Collection<PluginDefinition> getPluginDefinitions() {
        return pluginRegistry.getPlugins();
    }

    public PluginDefinition getPluginDefinition(String name) {
			return pluginRegistry.getPlugin(name);
		}

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
