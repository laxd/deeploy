package uk.laxd.deepweb.executor;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by lawrence on 24/02/16.
 */
@Component
public abstract class BuildFlowStepExecutor {
    public abstract void executeWithArguments(Map<String, String> arguments);
}
