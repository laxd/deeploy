package uk.laxd.deepweb.service;

import uk.laxd.deepweb.model.BuildFlowStep;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lawrence on 05/04/16.
 */
public interface BuildFlowStepService {
    BuildFlowStep findById(String id);
    Iterable<BuildFlowStep> findAll();
    void create(BuildFlowStep buildFlow);
}
