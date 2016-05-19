package uk.laxd.deepweb.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import uk.laxd.deepweb.dto.EditBuildFlowDto;
import uk.laxd.deepweb.dto.ViewBuildFlowDto;
import uk.laxd.deepweb.dto.ViewBuildFlowStepDto;
import uk.laxd.deepweb.lang.Constants;
import uk.laxd.deepweb.model.BuildFlow;
import uk.laxd.deepweb.service.BuildFlowService;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping(Constants.RequestMappings.BUILD_FLOW)
public class BuildFlowController {

	@Autowired
	private BuildFlowService buildFlowService;

	@RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
	public Iterable<BuildFlow> getFlows() {
		return buildFlowService.findAll();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public BuildFlow showBuildFlow(@PathVariable String id) {
		return buildFlowService.findById(id);
	}

}
