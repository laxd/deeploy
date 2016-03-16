package uk.laxd.deepweb.plugin;

/**
 * Created by lawrence on 15/03/16.
 */
public class PluginDefinition {

    private String name;
    private Class<? extends BuildFlowStepExecutor> executorClass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<? extends BuildFlowStepExecutor> getExecutorClass() {
        return executorClass;
    }

    public void setExecutorClass(Class<? extends BuildFlowStepExecutor> executorClass) {
        this.executorClass = executorClass;
    }
}
