package uk.laxd.deepweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.laxd.deepweb.lang.Constants;
import uk.laxd.deepweb.service.BuildFlowService;

/**
 * Created by Lenny on 19/09/2015.
 */
@Controller
@RequestMapping(Constants.RequestMappings.BUILD_FLOW)
public class ServerController {

    @Autowired
    private BuildFlowService buildFlowService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView showServer(ModelAndView modelAndView) {
        modelAndView.setViewName("buildflow/view");

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listServers(ModelAndView modelAndView) {
        modelAndView.setViewName("buildflow/list");
        modelAndView.addObject("buildFlows", buildFlowService.findAll());

        return modelAndView;
    }

}
