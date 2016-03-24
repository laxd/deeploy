package uk.laxd.deepweb.controller;

import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import uk.laxd.deepweb.dto.ExecutorDefinitionDto;
import uk.laxd.deepweb.lang.Constants;
import uk.laxd.deepweb.mapper.ExecutorDefinitionMapper;
import uk.laxd.deepweb.model.BuildFlowStep;
import uk.laxd.deepweb.model.BuildFlowStepArgument;
import uk.laxd.deepweb.service.BuildFlowService;
import org.springframework.web.servlet.view.RedirectView;
import uk.laxd.deepweb.model.BuildFlow;
import uk.laxd.deepweb.mapper.EditBuildFlowMapper;
import uk.laxd.deepweb.mapper.ViewBuildFlowMapper;
import uk.laxd.deepweb.mapper.ViewBuildFlowStepMapper;
import uk.laxd.deepweb.dto.EditBuildFlowDto;
import uk.laxd.deepweb.dto.ViewBuildFlowDto;
import uk.laxd.deepweb.dto.ViewBuildFlowStepDto;
import uk.laxd.deepweb.service.BuildFlowStepExecutorService;

/**
 * Created by Lenny on 19/09/2015.
 */
@Controller
@RequestMapping(Constants.RequestMappings.BUILD_FLOW)
public class BuildFlowController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BuildFlowController.class);

	@Autowired
	private BuildFlowService buildFlowService;

	@Autowired
	private BuildFlowStepExecutorService executorService;

	@Autowired
	private EditBuildFlowMapper editBuildFlowMapper;

	@Autowired
	private ViewBuildFlowMapper viewBuildFlowMapper;

	@Autowired
	private ViewBuildFlowStepMapper viewBuildFlowStepMapper;

	@Autowired
	private ExecutorDefinitionMapper executorDefinitionMapper;

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ModelAndView showBuildFlow(ModelAndView modelAndView,
			@PathVariable Long id) {
		LOGGER.debug("Showing build flow {}", id);
		modelAndView.setViewName("buildflow/view");
		modelAndView.addObject("buildFlow", buildFlowService.findById(id));

		BuildFlow buildFlow = buildFlowService.findById(id);

		ViewBuildFlowDto viewBuildFlow = viewBuildFlowMapper.mapToDto(buildFlow);

		Collection<ViewBuildFlowStepDto> steps = viewBuildFlowStepMapper.mapToDtos(buildFlow.getBuildFlowSteps());

		Collection<ExecutorDefinitionDto> executors = executorDefinitionMapper.mapToDtos(executorService.getPluginDefinitions());

		modelAndView.addObject("buildFlow", viewBuildFlow);
		modelAndView.addObject("steps", steps);
		modelAndView.addObject("executors", executors);

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listBuildFlows(ModelAndView modelAndView) {
		LOGGER.debug("Showing all build flows");

		modelAndView.setViewName("buildflow/list");
		modelAndView.addObject("buildFlows", buildFlowService.findAll());

		return modelAndView;
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public ModelAndView newBuildFlow(ModelAndView modelAndView) {
		modelAndView.setViewName("buildflow/edit");
		modelAndView.addObject("buildFlow", new EditBuildFlowDto());
		return modelAndView;
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public RedirectView addBuildFlow(@ModelAttribute("buildFlow") EditBuildFlowDto editBuildFlowDto) {
		BuildFlow buildFlow = editBuildFlowMapper.mapToEntity(editBuildFlowDto);

		buildFlowService.create(buildFlow);

		RedirectView redirectView = new RedirectView("/flow/" + buildFlow.getId());
		return redirectView;
	}

	@RequestMapping(value = "{id}/step/add")
	public void add(@PathVariable Long id, @RequestParam Map<String, String> arguments, String type) {
		BuildFlow buildFlow = buildFlowService.findById(id);

		// TODO: Push this down to service
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

		buildFlow.getBuildFlowSteps().add(buildFlowStep);
	}
}
