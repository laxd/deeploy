package uk.laxd.deepweb.executor;

import java.util.Map;

/**
 * Created by lawrence on 24/02/16.
 */
public class SshBuildFlowStepExecutor extends BuildFlowStepExecutor {



    public void executeWithArguments(Map<String, String> arguments) {
        String sshType = arguments.get("SSH_TYPE");
        String username = arguments.get("USERNAME");

        if("PASSWORD".equals(sshType)) {
            String password = arguments.get("PASSWORD");
        }
        else if("PRIVATE_KEY".equals(sshType)) {
            String privateKey = arguments.get("PRIVATE_KEY");
        }
        else if("PASSWORD_PROTECTED_PRIVATE_KEY".equals(sshType)) {
            String password = arguments.get("PASSWORD");
            String privateKey = arguments.get("PRIVATE_KEY");
        }

        String sshCommand = arguments.get("COMMAND");

        // Do SSH stuff

        //
        // Execute ssh!

    }
}
