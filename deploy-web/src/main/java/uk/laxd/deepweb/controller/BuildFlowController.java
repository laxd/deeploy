package uk.laxd.deepweb.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uk.laxd.deepweb.lang.Constants;
import uk.laxd.deepweb.service.BuildFlowService;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.RequestBody;
import uk.laxd.deepweb.model.BuildFlow;


/**
 * Created by Lenny on 19/09/2015.
 */
@Controller
@RequestMapping(Constants.RequestMappings.BUILD_FLOW)
public class BuildFlowController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BuildFlowController.class);

	@Autowired
	private BuildFlowService buildFlowService;

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ModelAndView showBuildFlow(ModelAndView modelAndView,
			@PathVariable Long id) {
		LOGGER.debug("Showing build flow {}", id);
		modelAndView.setViewName("buildflow/view");

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
		modelAndView.setViewName("buildflow/add");
		return modelAndView;
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public RedirectView addBuildFlow(@RequestBody BuildFlow buildFlow) {
		buildFlowService.create(buildFlow);

		RedirectView redirectView = new RedirectView("/flow/" + buildFlow.getId());
		return redirectView;
	}
}
