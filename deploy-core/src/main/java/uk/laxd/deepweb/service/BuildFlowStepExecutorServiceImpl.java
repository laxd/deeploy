package uk.laxd.deepweb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.laxd.deepweb.executor.ExecutorDefinitionFactory;
import uk.laxd.deepweb.model.BuildFlowStep;
import uk.laxd.deepweb.model.BuildFlowStepArgument;
import uk.laxd.deepweb.plugin.ExecutorDefinition;
import uk.laxd.deepweb.plugin.ExecutionResult;
import uk.laxd.deepweb.plugin.ExecutorManager;

import java.util.Collection;
import java.util.Map;

/**
 * Created by lawrence on 02/03/16.
 */
@Service
public class BuildFlowStepExecutorServiceImpl implements BuildFlowStepExecutorService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BuildFlowStepExecutorServiceImpl.class);

	@Autowired
	private ExecutorDefinitionFactory executorDefinitionFactory;

	@Autowired
	private BuildFlowStepArgumentService buildFlowStepArgumentService;

	@Autowired
	private ExecutorManager executorManager;

	@Override
	public ExecutionResult execute(BuildFlowStep buildFlowStep) {
		Collection<BuildFlowStepArgument> argumentList = buildFlowStep.getArguments();
		Map<String, String> arguments = buildFlowStepArgumentService.createArgumentMap(argumentList);

		ExecutorDefinition executorDefinition = executorManager.getExecutorDefinition(buildFlowStep.getExecutorName());

		LOGGER.info("Executing Build Flow Step {}", executorDefinition.getName());

		return executorDefinition.executeWithArguments(arguments);
	}

	@Override
	public Collection<ExecutorDefinition> getExecutorDefinitions() {
		return executorManager.getExecutorDefinitions();
	}
}
