package uk.laxd.deepweb.executor;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by lawrence on 25/02/16.
 */
@Component
public class ApplicationContextBuildFlowStepExecutorFactory implements BuildFlowStepExecutorFactory, ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public BuildFlowStepExecutor createExecutor(BuildFlowStepExecutorType type) {
        return applicationContext.getBean(type.getBeanClass());
    }
}
