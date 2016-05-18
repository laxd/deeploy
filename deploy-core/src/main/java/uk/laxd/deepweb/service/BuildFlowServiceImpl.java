package uk.laxd.deepweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.laxd.deepweb.dao.BuildFlowDao;
import uk.laxd.deepweb.model.BuildFlow;
import uk.laxd.deepweb.model.BuildFlowStep;
import uk.laxd.deepweb.model.BuildFlowStepArgument;

import java.util.*;

/**
 * Created by lawrence on 16/02/16.
 */
@Service
public class BuildFlowServiceImpl implements BuildFlowService {

	@Autowired
	private BuildFlowDao buildFlowDao;

	@Override
	public BuildFlow findById(Long id) {
		return buildFlowDao.findOne(id);
	}

	@Override
	public Iterable<BuildFlow> findAll() {
		return buildFlowDao.findAll();
	}

	@Override
	public void create(BuildFlow buildFlow) {
		buildFlowDao.save(buildFlow);
	}

	@Override
	public void addStep(Long id, String type, Map<String, String> arguments) {
		BuildFlowStep buildFlowStep = new BuildFlowStep();
		buildFlowStep.setExecutorName(type);

		for(String key : arguments.keySet()) {
			String value = arguments.get(key);
			BuildFlowStepArgument buildFlowStepArgument = new BuildFlowStepArgument();
			buildFlowStepArgument.setName(key);
			buildFlowStepArgument.setValue(value);
			buildFlowStepArgument.setBuildFlowStep(buildFlowStep);

			buildFlowStep.getArguments().add(buildFlowStepArgument);
		}

		BuildFlow buildFlow = this.findById(id);

		buildFlow.getBuildFlowSteps().add(buildFlowStep);

		buildFlowDao.save(buildFlow);
	}
}
