package uk.laxd.deepweb.executor;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.springframework.stereotype.Component;
import uk.laxd.deepweb.plugin.BuildFlowStepExecutor;

import java.util.Map;
import java.util.Properties;

/**
 * Created by lawrence on 24/02/16.
 */
@Component
public class SshBuildFlowStepExecutor extends BuildFlowStepExecutor {

    @Override
    public String getType() {
        return "SSH";
    }

    public void executeWithArguments(Map<String, String> arguments) {
        JSch jSch = new JSch();
        ChannelExec channel = null;
        Session session = null;

        try {
            session = getAuthenticatedSession(jSch, arguments);

            String command = arguments.get("COMMAND");

            channel = (ChannelExec) session.openChannel("exec");

            if (session.isConnected()) {
                channel.setCommand(command);

                channel.connect();
                channel.disconnect();
            }

            // TODO: Return exit status.
            // return channel.getExitStatus();

        } catch (JSchException e) {
            e.printStackTrace();
            // TODO: Return exit status
            // return 1;
        } finally {
            if (channel != null) {
                channel.disconnect();
            }

            if (session != null) {
                session.disconnect();
            }
        }
    }

    private Session getAuthenticatedSession(JSch jSch, Map<String, String> arguments) throws JSchException {
        String username = arguments.get("USERNAME");
        String hostname = arguments.get("HOSTNAME");
        int port = Integer.parseInt(arguments.get("PORT"));

        Session session = jSch.getSession(username, hostname, port);

        Properties properties = new Properties();
        properties.setProperty("StrictHostKeyChecking", "no");
        session.setConfig(properties);

        String sshType = arguments.get("SSH_TYPE");
        if ("PASSWORD".equals(sshType)) {
            session.setPassword(arguments.get("PASSWORD"));
        } else if ("PRIVATE_KEY".equals(sshType)) {
            jSch.addIdentity(arguments.get("PRIVATE_KEY"));
        } else if ("PASSWORD_PROTECTED_PRIVATE_KEY".equals(sshType)) {
            jSch.addIdentity(arguments.get("PRIVATE_KEY"),
                    arguments.get("PASSWORD"));
        }

        session.connect();

        return session;
    }
}
