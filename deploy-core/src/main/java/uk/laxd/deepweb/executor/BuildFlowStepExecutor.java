package uk.laxd.deepweb.executor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import uk.laxd.deepweb.lang.ExecutorNotFoundException;

import java.util.Map;

/**
 * Created by lawrence on 24/02/16.
 */
@Component
public abstract class BuildFlowStepExecutor implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BuildFlowStepExecutor.applicationContext = applicationContext;
    }

    public abstract void executeWithArguments(Map<String, String> arguments);

    public static BuildFlowStepExecutor findExecutor(BuildFlowStepExecutorType type) {
        return applicationContext.getBean(type.getBeanClass());
    }
}
