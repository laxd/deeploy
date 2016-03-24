package uk.laxd.deepweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.laxd.deepweb.plugin.PluginDefinition;
import uk.laxd.deepweb.service.BuildFlowStepExecutorService;

import java.util.Collection;

/**
 * Created by lawrence on 17/03/16.
 */
@Controller
@RequestMapping("/executor")
public class ExecutorController {

    @Autowired
    private BuildFlowStepExecutorService executorService;

    @RequestMapping(value = "modal")
    public ModelAndView getModal(String type) {
        Collection<PluginDefinition> definitions = executorService.getPluginDefinitions();

        ModelAndView modelAndView = new ModelAndView("buildflowstep/executor_config");

        for(PluginDefinition definition : definitions) {
            if(type.equals(definition.getExecutor().getName())) {
                // TODO: Map to DTO
                modelAndView.addObject("arguments", definition.getExecutor().getArguments());
            }
        }

        return modelAndView;
    }
}
