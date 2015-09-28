package uk.laxd.deepweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.laxd.deepweb.lang.Constants;
import uk.laxd.deepweb.service.ServerService;

/**
 * Created by Lenny on 19/09/2015.
 */
@Controller
@RequestMapping(Constants.RequestMappings.SERVERS)
public class ServerController {

    @Autowired
    @Qualifier(Constants.Service.SERVER_SERVICE)
    private ServerService serverService;

    @RequestMapping(path = Constants.CRUD.READ, method = RequestMethod.GET)
    public ModelAndView showServer(ModelAndView modelAndView) {
        modelAndView.setViewName("servers/view");

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listServers(ModelAndView modelAndView) {
        modelAndView.setViewName("servers/list");
        modelAndView.addObject("servers", serverService.findAll());

        return modelAndView;
    }

}
