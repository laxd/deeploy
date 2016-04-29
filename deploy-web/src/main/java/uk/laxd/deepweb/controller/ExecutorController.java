package uk.laxd.deepweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import uk.laxd.deepweb.executor.ExecutorDefinition;
import uk.laxd.deepweb.lang.ExecutorNotFoundException;
import uk.laxd.deepweb.service.BuildFlowStepExecutorService;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 * Created by lawrence on 17/03/16.
 */
@Controller
@RequestMapping("/executor")
public class ExecutorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExecutorController.class);

    @Autowired
    private BuildFlowStepExecutorService executorService;

    @RequestMapping(value = "modal")
    public ModelAndView getModal(String type) {
        LOGGER.debug("Getting modal for {}", type);

        ExecutorDefinition definition = executorService.getExecutorDefinitionByName(type);

        ModelAndView modelAndView = new ModelAndView("buildflowstep/executor_config");
        modelAndView.addObject("type", type);
        modelAndView.addObject("arguments", definition.getArguments());

        return modelAndView;
    }

    @ExceptionHandler(ExecutorNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleException(ExecutorNotFoundException exception) {
        LOGGER.error("Received exception: {}", exception.getMessage());
    }
}
