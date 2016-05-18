package uk.laxd.deepweb.controller;

import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import uk.laxd.deepweb.dto.ExecutorDefinitionDto;
import uk.laxd.deepweb.lang.Constants;
import uk.laxd.deepweb.lang.ExecutorDatabaseException;
import uk.laxd.deepweb.lang.ExecutorNotFoundException;
import uk.laxd.deepweb.mapper.ExecutorDefinitionMapper;
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

	@ModelAttribute("executors")
	public Collection<ExecutorDefinitionDto> getExecutorDefinitions() {
		return executorDefinitionMapper.mapToDtos(executorService.getExecutorDefinitions());
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ModelAndView showBuildFlow(ModelAndView modelAndView,
			@PathVariable Long id) {
		LOGGER.debug("Showing build flow {}", id);

		BuildFlow buildFlow = buildFlowService.findById(id);

		ViewBuildFlowDto buildFlowDto = viewBuildFlowMapper.mapToDto(buildFlow);

		Collection<ViewBuildFlowStepDto> steps = viewBuildFlowStepMapper.mapToDtos(buildFlow.getBuildFlowSteps());

		modelAndView.setViewName("buildflow/view");
		modelAndView.addObject("buildFlow", buildFlowDto);
		modelAndView.addObject("steps", steps);

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

		return new RedirectView("/flow/" + buildFlow.getId());
	}

	@RequestMapping(value = "{id}/step/add/{type}")
	@ResponseStatus(value = HttpStatus.OK)
	public void add(@PathVariable Long id, @RequestParam Map<String, String> arguments, @PathVariable String type) {
		buildFlowService.addStep(id, type, arguments);
	}

	@ExceptionHandler(ExecutorDatabaseException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public void handleException(ExecutorNotFoundException exception) {
		LOGGER.error("Received exception: {}", exception.getMessage());
	}
}
