package uk.laxd.deepweb.service;

import uk.laxd.deepweb.lang.NotFoundException;
import uk.laxd.deepweb.model.BuildFlowStepArgument;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by lawrence on 24/02/16.
 */
public interface BuildFlowStepArgumentService {
    BuildFlowStepArgument findById(Long id) throws NotFoundException;
    Map<String, String> createArgumentMap(Collection<BuildFlowStepArgument> argumentList);
}
