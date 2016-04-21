package uk.laxd.deepweb.service;

import org.springframework.stereotype.Component;
import uk.laxd.deepweb.model.BuildFlowStepArgument;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lawrence on 21/04/16.
 */
@Component
public class BuildFlowStepArgumentCollectionToMap implements CollectionToMap<String, String, BuildFlowStepArgument> {
    @Override
    public Map<String, String> toMap(Collection<BuildFlowStepArgument> arguments) {
        Map<String, String> map = new HashMap<>();

        for (BuildFlowStepArgument argument : arguments) {
            map.put(argument.getName(), argument.getValue());
        }

        return map;
    }
}
