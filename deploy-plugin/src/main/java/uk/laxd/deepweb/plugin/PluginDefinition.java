package uk.laxd.deepweb.plugin;

/**
 * Created by lawrence on 15/03/16.
 */
public class PluginDefinition {

    private Executor executor;

    public PluginDefinition(Executor executor) {
        this.executor = executor;
    }

    public Executor getExecutor() {
        return executor;
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }
}
