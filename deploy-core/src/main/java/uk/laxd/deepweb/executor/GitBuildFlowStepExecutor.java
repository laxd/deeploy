package uk.laxd.deepweb.executor;

import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.stereotype.Component;
import uk.laxd.deepweb.plugin.BuildFlowStepExecutor;
import uk.laxd.deepweb.plugin.ExecutionResult;
import uk.laxd.deepweb.plugin.ExecutorArgument;

import java.io.File;
import java.util.*;

/**
 * Created by lawrence on 26/02/16.
 */
@Component
public class GitBuildFlowStepExecutor extends BuildFlowStepExecutor {

    public GitBuildFlowStepExecutor() {
        super("GIT",
                "Git",
                new ExecutorArgument("URI", "URI", true),
                new ExecutorArgument("BRANCH", false),
                new ExecutorArgument("USERNAME", true),
                new ExecutorArgument("PASSWORD", true));
    }

    @Override
    public ExecutionResult executeWithArguments(Map<String, String> arguments) {
        UUID uuid = UUID.randomUUID();
        File gitLocation = new File("/tmp/git/" + uuid.toString());

        try {
            String uri = arguments.get("URI");
            String branch = arguments.get("BRANCH");
            // TODO: Implement other authentication types
            //String authenticationType = arguments.get("AUTH_TYPE");

            CloneCommand clone = Git.cloneRepository();
            clone.setDirectory(gitLocation)
                    .setBranchesToClone(Collections.singletonList(branch))
                    .setURI(uri);

            String username = arguments.get("USERNAME");
            String password = arguments.get("PASSWORD");

            clone.setCredentialsProvider(
                    new UsernamePasswordCredentialsProvider(username, password)
            );

            clone.call();
            return new ExecutionResult(0);
        } catch (Exception e) {
            e.printStackTrace();
            return new ExecutionResult(1, e.getMessage());
        }
        finally {
            gitLocation.delete();
        }
    }
}
