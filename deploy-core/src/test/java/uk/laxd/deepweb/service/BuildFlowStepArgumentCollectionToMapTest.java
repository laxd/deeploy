package uk.laxd.deepweb.service;

import org.junit.Before;
import org.junit.Test;
import uk.laxd.deepweb.model.BuildFlowStepArgument;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by lawrence on 21/04/16.
 */
public class BuildFlowStepArgumentCollectionToMapTest {

    private BuildFlowStepArgumentCollectionToMap buildFlowStepArgumentCollectionToMap;

    @Before
    public void setUp() throws Exception {
        buildFlowStepArgumentCollectionToMap = new BuildFlowStepArgumentCollectionToMap();
    }

    @Test
    public void testToMapMapsArgumentNameAndValue() throws Exception {
        Collection<BuildFlowStepArgument> arguments = new ArrayList<>();

        BuildFlowStepArgument buildFlowStepArgument = new BuildFlowStepArgument();
        buildFlowStepArgument.setName("KEY");
        buildFlowStepArgument.setValue("VALUE");

        arguments.add(buildFlowStepArgument);

        Map<String, String> argumentMap = buildFlowStepArgumentCollectionToMap.toMap(arguments);

        assertEquals(1, argumentMap.size());
        assertEquals("VALUE", argumentMap.get("KEY"));
    }
}