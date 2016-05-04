package uk.laxd.deepweb.lang;

/**
 * Created by lawrence on 03/05/16.
 */
public class ExecutorDatabaseException extends RuntimeException {
    public ExecutorDatabaseException() {
    }

    public ExecutorDatabaseException(String message) {
        super(message);
    }

    public ExecutorDatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
