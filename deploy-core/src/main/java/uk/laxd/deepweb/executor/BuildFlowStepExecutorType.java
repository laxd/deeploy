package uk.laxd.deepweb.executor;

/**
 * Created by lawrence on 24/02/16.
 */
public enum BuildFlowStepExecutorType {
    SSH(SshBuildFlowStepExecutor.class);

    private Class<? extends BuildFlowStepExecutor> beanClass;

    BuildFlowStepExecutorType(Class<? extends BuildFlowStepExecutor> beanClass) {
        this.beanClass = beanClass;
    }

    public Class<? extends BuildFlowStepExecutor> getBeanClass() {
        return beanClass;
    }
}
