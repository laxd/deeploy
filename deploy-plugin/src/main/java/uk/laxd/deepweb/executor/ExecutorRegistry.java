package uk.laxd.deepweb.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by lawrence on 14/03/16.
 */
@Component
public class ExecutorRegistry {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExecutorRegistry.class);

    private Collection<ExecutorDefinition> executors = new ArrayList<>();

    public Collection<ExecutorDefinition> getExecutors() {
        return executors;
    }

    public ExecutorDefinition getExecutor(String name) {
        LOGGER.info("Retrieving executor '{}'", name);

        return executors.stream()
            .filter(def -> def.getName().equals(name))
            .findFirst()
            .get();
    }

    public void register(ExecutorDefinition executorDefinition) {
        executors.add(executorDefinition);
    }
}
