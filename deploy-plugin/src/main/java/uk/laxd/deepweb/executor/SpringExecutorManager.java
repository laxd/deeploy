package uk.laxd.deepweb.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SpringExecutorManager implements ExecutorManager, ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringExecutorManager.class);

    private ApplicationContext applicationContext;

    @Autowired
    private ExecutorRegistry executorRegistry;

    @Override
    public void registerExecutors() {
        LOGGER.info("Registering executors ...");
        for (ExecutorDefinition executor : applicationContext.getBeansOfType(ExecutorDefinition.class).values()) {
            LOGGER.debug("Registering executor '{}'", executor.getName());

            executorRegistry.register(executor);
        }

        LOGGER.info("Registered {} executors!", executorRegistry.getExecutors().size());
    }

    @Override
    public void reRegisterExecutors() {
        executorRegistry = new ExecutorRegistry();
        registerExecutors();
    }

    @Override
    public Collection<ExecutorDefinition> getExecutorDefinitions() {
        return executorRegistry.getExecutors();
    }

    public ExecutorDefinition getExecutorDefinition(String name) {
        return executorRegistry.getExecutor(name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    protected ExecutorRegistry getExecutorRegistry() {
        return executorRegistry;
    }

    protected void setExecutorRegistry(ExecutorRegistry executorRegistry) {
        this.executorRegistry = executorRegistry;
    }
}
