package uk.laxd.deepweb.executor;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import uk.laxd.deepweb.plugin.BuildFlowStepExecutor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lawrence on 25/02/16.
 */
@Component
public class ApplicationContextBuildFlowStepExecutorFactory implements BuildFlowStepExecutorFactory, ApplicationContextAware {

    private Map<String, Class<? extends BuildFlowStepExecutor>> beans;

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;

        // Update bean definitions
        beans = new HashMap<>();

        Map<String, BuildFlowStepExecutor> executorMap = applicationContext.getBeansOfType(BuildFlowStepExecutor.class);

        for(BuildFlowStepExecutor buildFlowStepExecutor : executorMap.values()) {
            beans.put(buildFlowStepExecutor.getType(), buildFlowStepExecutor.getClass());
        }
    }

    public BuildFlowStepExecutor createExecutor(String type) {
        return applicationContext.getBean(beans.get(type));
    }
}
