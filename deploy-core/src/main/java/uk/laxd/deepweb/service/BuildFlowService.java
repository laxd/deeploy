package uk.laxd.deepweb.service;

import uk.laxd.deepweb.model.BuildFlow;

import java.util.List;
import java.util.Map;

/**
 * Created by lawrence on 16/02/16.
 */
public interface BuildFlowService {
	BuildFlow findById(Long id);
	List<BuildFlow> findAll();
	void create(BuildFlow buildFlow);
	void addStep(Long id, String type, Map<String, String> arguments);
}
