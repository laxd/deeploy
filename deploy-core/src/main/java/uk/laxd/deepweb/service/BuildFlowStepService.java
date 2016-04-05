package uk.laxd.deepweb.service;

import uk.laxd.deepweb.model.BuildFlowStep;

import java.util.List;

/**
 * Created by lawrence on 05/04/16.
 */
public interface BuildFlowStepService {
    BuildFlowStep findById(Long id);
    List<BuildFlowStep> findAll();
    void create(BuildFlowStep buildFlow);
}
