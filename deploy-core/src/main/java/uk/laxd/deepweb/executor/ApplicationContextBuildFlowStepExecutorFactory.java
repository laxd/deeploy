package uk.laxd.deepweb.executor;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import uk.laxd.deepweb.plugin.ExecutorDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lawrence on 25/02/16.
 */
@Component
public class ApplicationContextBuildFlowStepExecutorFactory implements BuildFlowStepExecutorFactory, ApplicationContextAware {

    private Map<String, Class<? extends ExecutorDefinition>> beans;

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;

        // Update bean definitions
        beans = new HashMap<>();

        Map<String, ExecutorDefinition> executorMap = applicationContext.getBeansOfType(ExecutorDefinition.class);

        for(ExecutorDefinition executorDefinition : executorMap.values()) {
            beans.put(executorDefinition.getName(), executorDefinition.getClass());
        }
    }

    public ExecutorDefinition createExecutor(String name) {
        return applicationContext.getBean(beans.get(name));
    }
}
