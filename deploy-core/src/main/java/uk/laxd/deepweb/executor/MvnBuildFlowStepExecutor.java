package uk.laxd.deepweb.executor;

import org.apache.maven.shared.invoker.*;
import uk.laxd.deepweb.plugin.BuildFlowStepExecutor;
import uk.laxd.deepweb.plugin.ExecutionResult;

import java.io.File;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by lawrence on 29/02/16.
 */
public class MvnBuildFlowStepExecutor extends BuildFlowStepExecutor {
    @Override
    public String getType() {
        return "MVN";
    }

    @Override
    public ExecutionResult executeWithArguments(Map<String, String> arguments) {
        InvocationRequest request = new DefaultInvocationRequest();

        request.setPomFile(new File(arguments.get("WORKSPACE"), "pom.xml"));
        request.setGoals(Arrays.asList("clean", "compile"));

        Invoker invoker = new DefaultInvoker();
        try {
            InvocationResult result = invoker.execute(request);

            return new ExecutionResult(result.getExitCode(), result.getExecutionException().getMessage());
        } catch (MavenInvocationException e) {
            return new ExecutionResult(1, e.getMessage());
        }
    }
}