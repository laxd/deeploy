package uk.laxd.deepweb.executor.lang;

import uk.laxd.deepweb.executor.ExecutorParameter;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by lawrence on 29/02/16.
 */
public class InvalidArgumentsException extends RuntimeException {

    private Collection<ExecutorParameter> invalidArguments;

    public InvalidArgumentsException(Collection<ExecutorParameter> invalidArguments) {
        super(String.format("Missing required parameters: %s", invalidArguments.stream()
                .map(ExecutorParameter::getName)
                .collect(Collectors.joining(", "))));
        this.invalidArguments = invalidArguments;
    }

    public Collection<ExecutorParameter> getInvalidArguments() {
        return invalidArguments;
    }
}
