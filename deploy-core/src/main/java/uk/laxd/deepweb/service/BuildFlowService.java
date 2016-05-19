package uk.laxd.deepweb.service;

import uk.laxd.deepweb.model.BuildFlow;

import java.util.List;
import java.util.Map;

/**
 * Created by lawrence on 16/02/16.
 */
public interface BuildFlowService {
	BuildFlow findById(String id);
	Iterable<BuildFlow> findAll();
	void create(BuildFlow buildFlow);
	void addStep(String id, String type, Map<String, String> arguments);
}
