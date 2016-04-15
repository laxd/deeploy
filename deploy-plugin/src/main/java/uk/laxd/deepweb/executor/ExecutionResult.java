package uk.laxd.deepweb.executor;

/**
 * Created by lawrence on 29/02/16.
 */
public class ExecutionResult {
    private int exitCode;
    private String message;

    public ExecutionResult(int exitCode) {
        this.exitCode = exitCode;
    }

    public ExecutionResult(int exitCode, String message) {
        this.exitCode = exitCode;
        this.message = message;
    }

    public int getExitCode() {
        return exitCode;
    }

    public void setExitCode(int exitCode) {
        this.exitCode = exitCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
