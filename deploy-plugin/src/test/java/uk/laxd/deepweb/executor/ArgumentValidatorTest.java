package uk.laxd.deepweb.executor;

import org.junit.Before;
import org.junit.Test;
import uk.laxd.deepweb.executor.lang.InvalidArgumentsException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by lawrence on 21/04/16.
 */
public class ArgumentValidatorTest {

    private ArgumentValidator argumentValidator;

    @Before
    public void setUp() throws Exception {
        argumentValidator = new ArgumentValidator();
    }

    @Test
    public void testInvalidArgumentsCauseException() throws Exception {
        Collection<ExecutorParameter> parameters = new ArrayList<>();
        parameters.add(new ExecutorParameter("A", true));

        try {
            argumentValidator.validate(parameters, new HashMap<>());
        }
        catch (InvalidArgumentsException e) {
            assertEquals(parameters, e.getInvalidArguments());
        }
    }

    @Test
    public void testNoExceptionThrownForAllValidParameters() throws Exception {
        Collection<ExecutorParameter> parameters = new ArrayList<>();
        parameters.add(new ExecutorParameter("A", true));

        Map<String, String> arguments = new HashMap<>();

        arguments.put("A", "Value");

        try {
            argumentValidator.validate(parameters, arguments);
        }
        catch (InvalidArgumentsException e) {
            fail("Exception should not have been thrown!");
        }
    }
}