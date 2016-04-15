package uk.laxd.deepweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.laxd.deepweb.plugin.ExecutorDefinition;
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
        Collection<ExecutorDefinition> definitions = executorService.getExecutorDefinitions();

        ModelAndView modelAndView = new ModelAndView("buildflowstep/executor_config");

        modelAndView.addObject("type", type);

        for(ExecutorDefinition definition : definitions) {
            if(type.equals(definition.getName())) {
                // TODO: Map to DTO
                modelAndView.addObject("arguments", definition.getArguments());
            }
        }

        return modelAndView;
    }
}
