package uk.laxd.deepweb.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import uk.laxd.deepweb.model.BuildFlowStepArgument;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by lawrence on 25/02/16.
 */
public class BuildFlowStepArgumentServiceJUnitTest {

    @Autowired
    private BuildFlowStepArgumentService buildFlowStepArgumentService = new BuildFlowStepArgumentServiceImpl();

    @Test
    public void testName() throws Exception {
        BuildFlowStepArgument buildFlowStepArgument = new BuildFlowStepArgument();
        buildFlowStepArgument.setName("TEST");
        buildFlowStepArgument.setValue("TEST_VALUE");

        BuildFlowStepArgument buildFlowStepArgument2 = new BuildFlowStepArgument();
        buildFlowStepArgument2.setName("TEST2");
        buildFlowStepArgument2.setValue("TEST_VALUE2");

        Collection<BuildFlowStepArgument> arguments = new ArrayList<>();
        arguments.add(buildFlowStepArgument);
        arguments.add(buildFlowStepArgument2);

        Map<String, String> result = buildFlowStepArgumentService.createArgumentMap(arguments);

        assertEquals(2, result.size());
    }
}