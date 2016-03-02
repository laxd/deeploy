package uk.laxd.deepweb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.laxd.deepweb.executor.BuildFlowStepExecutorFactory;
import uk.laxd.deepweb.model.BuildFlowStep;
import uk.laxd.deepweb.model.BuildFlowStepArgument;
import uk.laxd.deepweb.model.Executor;
import uk.laxd.deepweb.plugin.BuildFlowStepExecutor;
import uk.laxd.deepweb.plugin.ExecutionResult;

import java.util.Collection;
import java.util.Map;

/**
 * Created by lawrence on 02/03/16.
 */
@Service
public class BuildFlowStepExecutorServiceImpl implements BuildFlowStepExecutorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuildFlowStepExecutorServiceImpl.class);

    @Autowired
    private BuildFlowStepExecutorFactory buildFlowStepExecutorFactory;

    @Autowired
    private BuildFlowStepArgumentService buildFlowStepArgumentService;

    @Override
    public ExecutionResult execute(BuildFlowStep buildFlowStep) {
        Collection<BuildFlowStepArgument> argumentList = buildFlowStep.getArguments();
        Map<String, String> arguments = buildFlowStepArgumentService.createArgumentMap(argumentList);

        Executor executor = buildFlowStep.getExecutor();

        BuildFlowStepExecutor buildFlowStepExecutor = buildFlowStepExecutorFactory.createExecutor(executor.getType());

        LOGGER.info("Executing Build Flow Step {}", executor.getName());

        return buildFlowStepExecutor.executeWithArguments(arguments);
    }
}
