package uk.laxd.deepweb.service;

import uk.laxd.deepweb.lang.NotFoundException;
import uk.laxd.deepweb.model.BuildFlow;

import java.util.List;

/**
 * Created by lawrence on 16/02/16.
 */
public interface BuildFlowService {
    BuildFlow findById(Long id) throws NotFoundException;

    List<BuildFlow> findAll();
}
