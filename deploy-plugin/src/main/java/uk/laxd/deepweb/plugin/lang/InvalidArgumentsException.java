package uk.laxd.deepweb.plugin.lang;

/**
 * Created by lawrence on 29/02/16.
 */
public class InvalidArgumentsException extends RuntimeException {
    public InvalidArgumentsException() {
    }

    public InvalidArgumentsException(String message) {
        super(message);
    }

    public InvalidArgumentsException(String message, Throwable cause) {
        super(message, cause);
    }
}
