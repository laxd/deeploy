package uk.laxd.deepweb.executor;

import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.util.*;

/**
 * Created by lawrence on 26/02/16.
 */
public class GitBuildFlowStepExecutor extends BuildFlowStepExecutor {
    @Override
    public void executeWithArguments(Map<String, String> arguments) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            gitLocation.delete();
        }
    }
}
